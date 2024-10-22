package com.java.travel_cross_platform_be.DTOs.Request;

import com.java.travel_cross_platform_be.Model.Entity.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RegisterReq {

    @NotBlank(message = "User name is required")
    private String userName;
    @NotBlank(message = "First name is required")
    private String firstName;
    private String lastName;
    @Pattern(regexp = "^[\\w.%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$", message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String email;
    private String gender;
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number should be 10 digits")
    @NotBlank(message = "Phone number is required")
    private String phoneNumber;
    @Size(min = 6, message = "Password must be at least 6 characters")
    @NotBlank(message = "Password is required")
    private String password;
    private String address;
    private String nationality;
}

