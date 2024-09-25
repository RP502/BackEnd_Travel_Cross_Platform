package com.java.travel_cross_platform_be.DTOs.Request;


import com.java.travel_cross_platform_be.Valid.isValidEmail;
import jakarta.validation.constraints.Email;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginReq {

    @Email(message = "Email is not valid")
    private String email;
    private String password;
}
