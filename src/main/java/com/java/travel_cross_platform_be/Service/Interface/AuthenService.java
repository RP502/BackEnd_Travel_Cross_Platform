package com.java.travel_cross_platform_be.Service.Interface;

import com.java.travel_cross_platform_be.DTOs.Request.LoginReq;
import com.java.travel_cross_platform_be.DTOs.Request.RegisterReq;
import com.java.travel_cross_platform_be.DTOs.Response.LoginRes;
import com.java.travel_cross_platform_be.DTOs.Response.RegisterRes;

public interface AuthenService {
    LoginRes login(LoginReq request);
    RegisterRes register(RegisterReq request);
    boolean verifyAccount(String token);
    boolean regenerateOtp(String email);
    boolean forgotPassword(String email);
}