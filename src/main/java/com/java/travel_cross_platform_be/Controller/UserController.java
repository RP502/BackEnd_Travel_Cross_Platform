// src/main/java/com/java/travel_cross_platform_be/Controller/UserController.java
package com.java.travel_cross_platform_be.Controller;

import com.java.travel_cross_platform_be.DTOs.Response.ResponseEntity;
import com.java.travel_cross_platform_be.DTOs.Response.UserDTO;
import com.java.travel_cross_platform_be.Service.Interface.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v2/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity createUser(@RequestBody UserDTO userDTO) {
        UserDTO createdUser = userService.createUser(userDTO);
        ResponseEntity response = null;
        if (createdUser == null) {
            response = ResponseEntity.builder()
                    .message("Email already exists")
                    .status(HttpStatus.BAD_REQUEST)
                    .data(null)
                    .build();
        } else {
            response = ResponseEntity.builder()
                    .message("User created successfully")
                    .status(HttpStatus.OK)
                    .data(createdUser)
                    .build();
        }
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity getUserById(@PathVariable Long id) {
        Optional<UserDTO> userDTO = userService.getUserById(id);
        ResponseEntity response = null;
        if (userDTO.isPresent()) {
            response = ResponseEntity.builder()
                    .message("User retrieved successfully")
                    .status(HttpStatus.OK)
                    .data(userDTO.get())
                    .build();
        } else {
            response = ResponseEntity.builder()
                    .message("User not found")
                    .status(HttpStatus.NOT_FOUND)
                    .data(null)
                    .build();
        }
        return response;
    }

    @PutMapping("/{id}")
    public ResponseEntity updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        UserDTO updatedUser = userService.updateUser(id, userDTO);
        ResponseEntity response = null;
        if (updatedUser == null) {
            response = ResponseEntity.builder()
                    .message("Email already exists")
                    .status(HttpStatus.BAD_REQUEST)
                    .data(null)
                    .build();
        } else {
            response = ResponseEntity.builder()
                    .message("User updated successfully")
                    .status(HttpStatus.OK)
                    .data(updatedUser)
                    .build();
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        ResponseEntity response = null;
        if (userService.getUserById(id).isEmpty()) {
            response = ResponseEntity.builder()
                    .message("User deleted successfully")
                    .status(HttpStatus.OK)
                    .data(null)
                    .build();
        } else {
            response = ResponseEntity.builder()
                    .message("User not found")
                    .status(HttpStatus.NOT_FOUND)
                    .data(null)
                    .build();
        }
        return response;
    }

    @GetMapping
    public ResponseEntity getAllUsers() {
        List<UserDTO> users = userService.getAllUsers();
        ResponseEntity response = null;
        if (users.isEmpty()) {
            response = ResponseEntity.builder()
                    .message("No user found")
                    .status(HttpStatus.NOT_FOUND)
                    .data(null)
                    .build();
        } else {
            response = ResponseEntity.builder()
                    .message("Users retrieved successfully")
                    .status(HttpStatus.OK)
                    .data(users)
                    .build();
        }
        return response;
    }
}