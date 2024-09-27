package com.java.travel_cross_platform_be.Repository.Interface;

import com.java.travel_cross_platform_be.Model.Entity.TravelUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<TravelUser, Long> {
    Optional<TravelUser> findTravelUserByUserName(String username);
    Optional<TravelUser> findByEmail(String email);
    Optional<TravelUser> findByVerificationCode(String verificationCode);
    Optional<TravelUser> existsByEmail(String email);
}