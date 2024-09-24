// src/main/java/com/java/travel_cross_platform_be/Service/Implement/UserServiceImpl.java
package com.java.travel_cross_platform_be.Service.Implement;

import com.java.travel_cross_platform_be.DTOs.Response.UserDTO;
import com.java.travel_cross_platform_be.Model.User;
import com.java.travel_cross_platform_be.Repository.Interface.UserRepo;
import com.java.travel_cross_platform_be.Service.Interface.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepository;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        User savedUser = userRepository.save(user);
        UserDTO savedUserDTO = new UserDTO();
        BeanUtils.copyProperties(savedUser, savedUserDTO);
        return savedUserDTO;
    }

    @Override
    public Optional<UserDTO> getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(user.get(), userDTO);
            return Optional.of(userDTO);
        }
        return Optional.empty();
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            User user = existingUser.get();
            BeanUtils.copyProperties(userDTO, user);
            User updatedUser = userRepository.save(user);
            UserDTO updatedUserDTO = new UserDTO();
            BeanUtils.copyProperties(updatedUser, updatedUserDTO);
            return updatedUserDTO;
        }
        return null;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(user -> {
            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(user, userDTO);
            return userDTO;
        }).collect(Collectors.toList());
    }
}