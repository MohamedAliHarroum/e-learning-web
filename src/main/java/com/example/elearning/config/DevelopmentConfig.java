package com.example.elearning.config;

import com.example.elearning.domain.Address;
import com.example.elearning.domain.Student;
import com.example.elearning.repositories.UserRepository;
import com.example.elearning.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;

@Profile("!production")
@Configuration
public class DevelopmentConfig {

    @Bean
    public CommandLineRunner databaseLoader(UserService userService,
                                            PasswordEncoder encoder) {
        return args -> {
            Address address = new Address(
                    "Rue Tunis", "Monastir",
                    "Monastir","Tunisia", 5000
            );

            Student student = new Student(
                    "riadh@gmail.com", "riadh",
                    "Riadh", "Laabidi",
                    "+21655305173", address,
                    Collections.emptySet(),
                    Collections.emptySet()
            );

            userService.add(student);
        };
    }


}
