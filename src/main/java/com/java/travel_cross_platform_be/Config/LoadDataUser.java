package com.java.travel_cross_platform_be.Config;//package com.example.AudioBook.Config.Data;

import com.java.travel_cross_platform_be.Repository.Interface.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class LoadDataUser {
    @Bean
    public CommandLineRunner loadUser(UserRepository userRepo) {
        return args -> {
            userRepo.deleteAll();
        };
    }
}
