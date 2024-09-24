package com.java.travel_cross_platform_be.Repository.Interface;

import com.java.travel_cross_platform_be.Model.User;
import com.java.travel_cross_platform_be.Repository.Interface.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findUserByUserName(String username);
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
    Optional<User> findByVerificationToken(String token);
}