package com.java.travel_cross_platform_be.Config;


import com.java.travel_cross_platform_be.Model.Entity.Role;
import com.java.travel_cross_platform_be.Model.Entity.TravelUser;
import com.java.travel_cross_platform_be.Model.Enum.ERole;
import com.java.travel_cross_platform_be.Repository.Interface.RoleRepository;
import com.java.travel_cross_platform_be.Repository.Interface.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class InitData implements CommandLineRunner {
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public void run(String... args) throws Exception {

        if (roleRepository.existsByName(String.valueOf(ERole.ROLE_ADMIN)).isEmpty()) {
            createRoles();
        }
    }

    public void createRoles() {
        Role roleAdmin = new Role();
        roleAdmin.setName(ERole.ROLE_ADMIN);
        roleRepository.save(roleAdmin);

        Role roleUser = new Role();
        roleUser.setName(ERole.ROLE_USER);
        roleRepository.save(roleUser);
    }
}
