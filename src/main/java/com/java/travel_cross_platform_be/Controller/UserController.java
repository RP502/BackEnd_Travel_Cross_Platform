package com.java.travel_cross_platform_be.Controller;


import com.java.travel_cross_platform_be.DTOs.BaseResponse;
import com.java.travel_cross_platform_be.DTOs.DTO.UserDTO;
import com.java.travel_cross_platform_be.Model.Entity.TravelUser;
import com.java.travel_cross_platform_be.Service.Interface.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v2/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/me")
    public ResponseEntity<BaseResponse<UserDTO>> authenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            String email = authentication.getName();
            Optional<UserDTO> userDTO = userService.getUserByEmail(email);
            if (userDTO.isPresent()) {
                BaseResponse<UserDTO> response = new BaseResponse<>("User found", userDTO.get());
                return ResponseEntity.ok(response);
            }
        }
        BaseResponse<UserDTO> response = new BaseResponse<>("User not found", null);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BaseResponse<UserDTO>> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        UserDTO updatedUserDTO = userService.updateUser(id, userDTO);
        BaseResponse<UserDTO> response = new BaseResponse<>("User updated", updatedUserDTO);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse<Void>> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        BaseResponse<Void> response = new BaseResponse<>("User deleted", null);
        return ResponseEntity.ok(response);
    }



}