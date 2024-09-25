// src/main/java/com/java/travel_cross_platform_be/Service/Implement/UserServiceImpl.java
package com.java.travel_cross_platform_be.Service.Implement;

import com.java.travel_cross_platform_be.DTOs.Response.UserDTO;
import com.java.travel_cross_platform_be.Model.Entity.TravelUser;
import com.java.travel_cross_platform_be.Repository.Interface.UserRepository;
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

    private final UserRepository userRepository;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        TravelUser travelUser = new TravelUser();
        BeanUtils.copyProperties(userDTO, travelUser);
        TravelUser savedTravelUser = userRepository.save(travelUser);
        UserDTO savedUserDTO = new UserDTO();
        BeanUtils.copyProperties(savedTravelUser, savedUserDTO);
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
            TravelUser travelUser = existingUser.get();
            BeanUtils.copyProperties(userDTO, travelUser);
            TravelUser updatedTravelUser = userRepository.save(travelUser);
            UserDTO updatedUserDTO = new UserDTO();
            BeanUtils.copyProperties(updatedTravelUser, updatedUserDTO);
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
        List<TravelUser> travelUsers = userRepository.findAll();
        return travelUsers.stream().map(travelUser -> {
            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(travelUser, userDTO);
            return userDTO;
        }).collect(Collectors.toList());
    }
}