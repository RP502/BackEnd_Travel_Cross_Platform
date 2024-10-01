package com.java.travel_cross_platform_be.Controller;

import com.java.travel_cross_platform_be.DTOs.BaseResponse;
import com.java.travel_cross_platform_be.DTOs.Request.LoginReq;
import com.java.travel_cross_platform_be.DTOs.Request.RegisterReq;
import com.java.travel_cross_platform_be.DTOs.Request.VerifyReq;
import com.java.travel_cross_platform_be.DTOs.Response.LoginRes;
import com.java.travel_cross_platform_be.DTOs.Response.RegisterRes;
import com.java.travel_cross_platform_be.DTOs.Response.VerifyRes;
import com.java.travel_cross_platform_be.Service.Interface.AuthenService;
import com.java.travel_cross_platform_be.Service.Jwt.JwtService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Validated
public class AuthenController {

    private final AuthenService authenticationService;
    private final JwtService jwtService;

    @PostMapping("/register")
    public ResponseEntity<BaseResponse<RegisterRes>> register(@Valid @RequestBody RegisterReq registerUserDto) {
        RegisterRes registeredUser = authenticationService.register(registerUserDto);
        BaseResponse<RegisterRes> response = new BaseResponse<>(registeredUser.isStatus() ? "Success" : "Failed", registeredUser.isStatus() ? registeredUser : null);
        return ResponseEntity
                .status(registeredUser.isStatus() ? HttpStatus.OK : HttpStatus.BAD_REQUEST)
                .body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<BaseResponse<LoginRes>> authenticate(@Valid @RequestBody LoginReq loginUserDto){
        LoginRes authenticatedUser = authenticationService.login(loginUserDto);
        BaseResponse<LoginRes> response = new BaseResponse<>(authenticatedUser.isStatus() ? "Success" : "Failed", authenticatedUser.isStatus() ? authenticatedUser : null);
        return ResponseEntity
                .status(authenticatedUser.isStatus() ? HttpStatus.OK : HttpStatus.BAD_REQUEST)
                .body(response);
    }


    @PostMapping("/verify")
    public ResponseEntity<BaseResponse<VerifyRes>> verifyUser(@Valid @RequestBody VerifyReq verifyUserDto) {
        VerifyRes verifyRes = authenticationService.verifyAccount(verifyUserDto);
        BaseResponse<VerifyRes> response = new BaseResponse<>(verifyRes.isStatus() ? "Success" : "Failed", verifyRes.isStatus() ? verifyRes : null);
        return ResponseEntity
                .status(verifyRes.isStatus() ? HttpStatus.OK : HttpStatus.BAD_REQUEST)
                .body(response);
    }

    @PostMapping("/resend")
    public ResponseEntity<BaseResponse<Boolean>> resendVerificationCode(@Valid @RequestParam String email) {
        authenticationService.regenerateOtp(email);
        BaseResponse<Boolean> response = new BaseResponse<>("New verification code was sent to your email !", true);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<BaseResponse<Boolean>> forgotPassword(@RequestParam String email) {
        authenticationService.forgotPassword(email);
        BaseResponse<Boolean> response = new BaseResponse<>("New password was sent to your email !", true);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }
}