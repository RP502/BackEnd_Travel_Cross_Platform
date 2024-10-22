package com.java.travel_cross_platform_be.Config;//package com.example.AudioBook.Config.Data;

import com.java.travel_cross_platform_be.Model.Entity.Role;
import com.java.travel_cross_platform_be.Model.Entity.TravelUser;
import com.java.travel_cross_platform_be.Model.Enum.ERole;
import com.java.travel_cross_platform_be.Repository.Interface.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.Set;

import static java.lang.System.currentTimeMillis;

@Configuration
@RequiredArgsConstructor
public class LoadDataUser {

    @Bean
    public CommandLineRunner loadUser(UserRepository userRepo, PasswordEncoder passwordEncoder) {
        return args -> {
            if (userRepo.existsByEmail("admin@admin.vn").isPresent()) {
                return;
            } else {
                System.out.println("No user found, creating new user...");
            }
            TravelUser user = new TravelUser();
            user.setUserName("admin");
            String password = "admin123";
            user.setPassword(passwordEncoder.encode(password));
            user.setEnabled(true);
            user.setEmail("admin@admin.vn");
            user.setCreatedAt(LocalDateTime.now());
            user.setUpdatedAt(LocalDateTime.now());
            user.setPhoneNumber("0123456789");
            user.setFirstName("Admin");
            user.setLastName("Admin");
            user.setRoles(Set.of(new Role(ERole.ROLE_ADMIN)));
            userRepo.save(user);
        };
    }
}
