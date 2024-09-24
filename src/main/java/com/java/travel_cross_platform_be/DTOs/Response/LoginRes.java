package com.java.travel_cross_platform_be.DTOs.Response;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginRes {
    private String token;
    private String userName;
    private String email;
    private String role;
    private String status;
    private String message;
}
