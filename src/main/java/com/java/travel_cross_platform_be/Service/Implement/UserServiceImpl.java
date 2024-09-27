package com.java.travel_cross_platform_be.Service.Implement;


import com.java.travel_cross_platform_be.DTOs.DTO.UserDTO;
import com.java.travel_cross_platform_be.Model.Entity.TravelUser;
import com.java.travel_cross_platform_be.Repository.Interface.UserRepository;
import com.java.travel_cross_platform_be.Service.Interface.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        TravelUser user = new TravelUser();
        BeanUtils.copyProperties(userDTO, user);
        TravelUser savedUser = userRepository.save(user);
        UserDTO savedUserDTO = new UserDTO();
        BeanUtils.copyProperties(user, savedUserDTO);
        return savedUserDTO;
    }

    @Override
    public Optional<UserDTO> getUserById(Long id) {
        Optional<TravelUser> user = userRepository.findById(id);
        if (user.isPresent()) {
            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(user.get(), userDTO);
            return Optional.of(userDTO);
        }
        return Optional.empty();
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        Optional<TravelUser> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            TravelUser user = existingUser.get();
            BeanUtils.copyProperties(userDTO, user);
            TravelUser updatedUser = userRepository.save(user);
            UserDTO updatedUserDTO = new UserDTO();
            BeanUtils.copyProperties(user, updatedUserDTO);
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
        List<TravelUser> users = userRepository.findAll();
        return users.stream().map(user -> {
            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(user, userDTO);
            return userDTO;
        }).collect(Collectors.toList());
    }
}