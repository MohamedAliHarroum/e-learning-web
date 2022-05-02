package com.example.elearning.services;

import com.example.elearning.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ELearningUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public ELearningUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findById(username).orElseThrow(
                () ->new UsernameNotFoundException("User '" + username + "' not found")
        );
    }
}

