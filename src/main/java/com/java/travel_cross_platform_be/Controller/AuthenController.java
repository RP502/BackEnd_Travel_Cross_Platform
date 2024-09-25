package com.java.travel_cross_platform_be.Controller;

import com.java.travel_cross_platform_be.DTOs.Request.LoginReq;
import com.java.travel_cross_platform_be.DTOs.Request.RegisterReq;
import com.java.travel_cross_platform_be.DTOs.Response.ResponseEntity;
import com.java.travel_cross_platform_be.DTOs.Response.LoginRes;
import com.java.travel_cross_platform_be.DTOs.Response.RegisterRes;
import com.java.travel_cross_platform_be.Service.Interface.AuthenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenController {

    private final AuthenService authenService;

    @Operation(summary = "Get a greeting message")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved message"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginReq request) {
        LoginRes response = authenService.login(request);
        ResponseEntity responseEntity = null;
        if (response == null) {
            responseEntity = ResponseEntity.builder()
                    .message("Invalid email or password")
                    .status(HttpStatus.BAD_REQUEST)
                    .data(null)
                    .build();
        } else {
            responseEntity = ResponseEntity.builder()
                    .message("Login successfully")
                    .status(HttpStatus.OK)
                    .data(response)
                    .build();
        }
        return responseEntity;
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterReq request) {
        RegisterRes response = authenService.register(request);
        ResponseEntity responseEntity = null;
        if (response == null) {
            responseEntity = ResponseEntity.builder()
                    .message("Email already exists")
                    .status(HttpStatus.BAD_REQUEST)
                    .data(null)
                    .build();
        } else {
            responseEntity = ResponseEntity.builder()
                    .message("Register successfully")
                    .status(HttpStatus.OK)
                    .data(response)
                    .build();
        }
        return responseEntity;
    }

    @GetMapping("/verify")
    public ResponseEntity verifyAccount(@RequestParam String token) {
        boolean isVerified = authenService.verifyAccount(token);
        ResponseEntity responseEntity = null;
        if (isVerified) {
            responseEntity = ResponseEntity.builder()
                    .message("Account verified")
                    .status(HttpStatus.OK)
                    .data(true)
                    .build();
        } else {
            responseEntity = ResponseEntity.builder()
                    .message("Invalid token")
                    .status(HttpStatus.BAD_REQUEST)
                    .data(false)
                    .build();
        }
        return responseEntity;
    }

    @PostMapping("/regenerate-otp")
    public ResponseEntity regenerateOtp(@RequestParam String email) {
        boolean isOtpRegenerated = authenService.regenerateOtp(email);
        ResponseEntity responseEntity = null;
        if (isOtpRegenerated) {
            responseEntity = ResponseEntity.builder()
                    .message("OTP regenerated")
                    .status(HttpStatus.OK)
                    .data(true)
                    .build();
        } else {
            responseEntity = ResponseEntity.builder()
                    .message("Invalid email")
                    .status(HttpStatus.BAD_REQUEST)
                    .data(false)
                    .build();
        }
        return responseEntity;
    }

    @PostMapping("/forgot-password")
    public ResponseEntity forgotPassword(@RequestParam String email) {
        boolean isPasswordReset = authenService.forgotPassword(email);
        ResponseEntity responseEntity = null;
        if (isPasswordReset) {
            responseEntity = ResponseEntity.builder()
                    .message("Password reset")
                    .status(HttpStatus.OK)
                    .data(true)
                    .build();
        } else {
            responseEntity = ResponseEntity.builder()
                    .message("Invalid email")
                    .status(HttpStatus.BAD_REQUEST)
                    .data(false)
                    .build();
        }
        return responseEntity;
    }
}