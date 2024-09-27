package com.java.travel_cross_platform_be.DTOs.Response;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginRes {
    private boolean status;
    private String token;
    private long expiresIn;
}
