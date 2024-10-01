package com.java.travel_cross_platform_be.Service.Implement;

import com.java.travel_cross_platform_be.Converter.UserConverter;
import com.java.travel_cross_platform_be.DTOs.Request.LoginReq;
import com.java.travel_cross_platform_be.DTOs.Request.RegisterReq;
import com.java.travel_cross_platform_be.DTOs.Request.VerifyReq;
import com.java.travel_cross_platform_be.DTOs.Response.LoginRes;
import com.java.travel_cross_platform_be.DTOs.Response.RegisterRes;
import com.java.travel_cross_platform_be.DTOs.Response.VerifyRes;
import com.java.travel_cross_platform_be.Exception.EmailMessageException;
import com.java.travel_cross_platform_be.Exception.UserAlreadyExistsException;
import com.java.travel_cross_platform_be.Exception.UserInvalidException;
import com.java.travel_cross_platform_be.Exception.UserNotFoundException;
import com.java.travel_cross_platform_be.Model.Entity.TravelUser;
import com.java.travel_cross_platform_be.Repository.Interface.UserRepository;
import com.java.travel_cross_platform_be.Service.Interface.AuthenService;
import com.java.travel_cross_platform_be.Service.Interface.MailService;
import com.java.travel_cross_platform_be.Service.Jwt.JwtService;
import com.java.travel_cross_platform_be.Util.Authentication.PasswordUtil;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

import static com.java.travel_cross_platform_be.Util.Authentication.OtpUtil.generateOtp;

@Service
@RequiredArgsConstructor
public class AuthenServiceImpl implements AuthenService {

    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final MailService emailService;
    private final UserConverter userConverter;
    private final JwtService jwtService;

    @Override
    public RegisterRes register(RegisterReq request) {
        System.out.println("Register service receive:" + request.toString());
        validateUserExists(request.getEmail());  // Kiểm tra xem email đã tồn tại hay chưa
        TravelUser user = userConverter.convertToEntity(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));  // Mã hóa mật khẩu
        user.setVerificationCode(generateOtp());  // Tạo mã xác nhận
        user.setVerificationCodeExpiresAt(LocalDateTime.now().plusMinutes(1));  // Thời gian hết hạn của mã xác nhận
        sendVerificationEmail(user);  // Gửi email xác nhận
        userRepository.save(user);  // Lưu người dùng vào cơ sở dữ liệu
        return RegisterRes.builder()
                .status(true)
                .message("Register successfully. Please verify your account.")
                .email(user.getEmail())
                .build();
    }


    @Override
    public LoginRes login(LoginReq request) {
        try {
            TravelUser user = userRepository.findByEmail(request.getEmail()).orElseThrow(
                    () -> new UserNotFoundException("User with email " + request.getEmail() + " not found")
            );

            if (!user.isEnabled()) {
                throw new UserInvalidException("Account with email "+request.getEmail() +" is not verified");
            }

            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
            );

            String jwtToken = jwtService.generateToken(user);
            return LoginRes.builder()
                    .status(true)
                    .token(jwtToken)
                    .expiresIn(jwtService.getExpirationTime())
                    .build();
        } catch (BadCredentialsException ex) {
            throw new UserInvalidException("Invalid email or password");
        }
    }


    @Override
    public VerifyRes verifyAccount(VerifyReq request) {
        Optional<TravelUser> optionalUser = userRepository.findByEmail(request.getEmail());
        if (optionalUser.isPresent()) {
            TravelUser user = optionalUser.get();
            if (user.getVerificationCodeExpiresAt().isBefore(LocalDateTime.now())) {
                throw new UserInvalidException("Verification code has expired");
            }
            if (user.isEnabled()) {
                throw new UserInvalidException("User already in use, please try again !");
            }
            if (user.getVerificationCode().equals(request.getVerificationCode())) {
                user.setEnabled(true);
                user.setVerificationCode(null);
                user.setVerificationCodeExpiresAt(null);
                String token = jwtService.generateToken(user);
                userRepository.save(user);
                VerifyRes verifyRes = VerifyRes.builder()
                        .status(true)
                        .message("Account verified successfully")
                        .email(user.getEmail())
                        .token(token)
                        .expiresIn(jwtService.getExpirationTime())
                        .build();
                return verifyRes;
            } else {
                throw new UserInvalidException("Invalid verification code");
            }
        } else {
            throw new UserNotFoundException("User not found");
        }
    }

    @Override
    public void regenerateOtp(String email) {
        try {
            Optional<TravelUser> optionalUser = userRepository.findByEmail(email);
            if (optionalUser.isPresent()) {
                TravelUser user = optionalUser.get();
                if (user.isEnabled()) {
                    throw new RuntimeException("Account is already verified");
                }
                user.setVerificationCode(generateOtp());
                user.setVerificationCodeExpiresAt(LocalDateTime.now().plusHours(1));
                sendVerificationEmail(user);
                userRepository.save(user);
            } else {
                throw new UserNotFoundException("User not found");
            }
        } catch (Exception ex) {
            throw new RuntimeException("An error occurred while regenerating OTP");
        }

    }

    @Override
    public void forgotPassword(String email) {
        Optional<TravelUser> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            try {
                String newPassword = PasswordUtil.generatePassword();
                user.get().setPassword(passwordEncoder.encode(newPassword));
                emailService.sendVerificationMail(email, "Reset Password", "Your new password is: " + newPassword);
                userRepository.save(user.get());
            } catch (Exception ex) {
                throw new RuntimeException("An error occurred while sending the email");
            }
        } else {
            throw new UserNotFoundException("User with email " + email + " not found");
        }
    }

    private void validateUserExists(String email) {
        Optional<TravelUser> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            if (user.get().isEnabled()) {
                throw new UserAlreadyExistsException("User with email " + email + " already exists");
            }
        }
    }



    private void sendVerificationEmail(TravelUser user) {
        String subject = "Account Verification";
        String verificationCode = "VERIFICATION CODE " + user.getVerificationCode();
        String htmlMessage = "<html>"
                + "<body style=\"font-family: Arial, sans-serif;\">"
                + "<div style=\"background-color: #f5f5f5; padding: 20px;\">"
                + "<h2 style=\"color: #333;\">Welcome to our app!</h2>"
                + "<p style=\"font-size: 16px;\">Please enter the verification code below to continue:</p>"
                + "<div style=\"background-color: #fff; padding: 20px; border-radius: 5px; box-shadow: 0 0 10px rgba(0,0,0,0.1);\">"
                + "<h3 style=\"color: #333;\">Verification Code:</h3>"
                + "<p style=\"font-size: 18px; font-weight: bold; color: #007bff;\">" + verificationCode + "</p>"
                + "</div>"
                + "</div>"
                + "</body>"
                + "</html>";

        try {
            emailService.sendVerificationMail(user.getEmail(), subject, htmlMessage);
        } catch (MessagingException e) {
            // Handle email sending exception
            throw new EmailMessageException("An error occurred while sending the email: " + e.getMessage());
        }
    }
}