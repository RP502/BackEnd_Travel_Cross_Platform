package com.java.travel_cross_platform_be.DTOs.Response;


import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VerifyRes {
    private boolean status;
    private String message;
    private String email;
    private String token;
    private long expiresIn;
}
