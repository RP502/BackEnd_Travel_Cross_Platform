package com.java.travel_cross_platform_be.Service.Interface;

import com.java.travel_cross_platform_be.DTOs.Request.LoginReq;
import com.java.travel_cross_platform_be.DTOs.Request.RegisterReq;
import com.java.travel_cross_platform_be.DTOs.Request.VerifyReq;
import com.java.travel_cross_platform_be.DTOs.Response.LoginRes;
import com.java.travel_cross_platform_be.DTOs.Response.RegisterRes;
import com.java.travel_cross_platform_be.DTOs.Response.VerifyRes;

public interface AuthenService {
    LoginRes login(LoginReq request);
    RegisterRes register(RegisterReq request);
    VerifyRes verifyAccount(VerifyReq request);
    void regenerateOtp(String email);
    void forgotPassword(String email);
}