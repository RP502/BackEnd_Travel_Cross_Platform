package com.java.travel_cross_platform_be.DTOs.Request;


import com.java.travel_cross_platform_be.Valid.isValidEmail;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginReq {

    @isValidEmail
    private String email;
    private String password;
}
