package com.java.travel_cross_platform_be.Service.Implement;

import com.java.travel_cross_platform_be.DTOs.Request.LoginReq;
import com.java.travel_cross_platform_be.DTOs.Request.RegisterReq;
import com.java.travel_cross_platform_be.DTOs.Response.LoginRes;
import com.java.travel_cross_platform_be.DTOs.Response.RegisterRes;
import com.java.travel_cross_platform_be.Repository.Interface.UserRepo;
import com.java.travel_cross_platform_be.Service.Interface.AuthenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenServiceImpl implements AuthenService {

    @Override
    public LoginRes login(LoginReq request) {
        return null;
    }

    @Override
    public RegisterRes register(RegisterReq request) {
        return null;
    }

    @Override
    public boolean verifyAccount(String token) {
        return false;
    }

    @Override
    public boolean regenerateOtp(String email) {
        return false;
    }

    @Override
    public boolean forgotPassword(String email) {
        return false;
    }
}