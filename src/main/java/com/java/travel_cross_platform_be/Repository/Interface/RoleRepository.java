package com.java.travel_cross_platform_be.Repository.Interface;

import com.java.travel_cross_platform_be.Model.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> existsByName(String name);
}
