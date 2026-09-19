package com.example.career_education_advisor.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.career_education_advisor.DTO.LoginDTO;
import com.example.career_education_advisor.DTO.RegisterDTO;
import com.example.career_education_advisor.Models.Role;
import com.example.career_education_advisor.Models.User;
import com.example.career_education_advisor.Repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // ================= REGISTER =================

    public User register(RegisterDTO request) {

        // Email check
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        // Phone check
        if (userRepository.existsByPhone(request.getPhone())) {
            throw new RuntimeException("Phone already exists");
        }

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());

        // Password encryption
        user.setPassword(
                passwordEncoder.encode(request.getPassword()));

        user.setPhone(request.getPhone());

        // Normal registration = STUDENT
        user.setRole(Role.STUDENT);

        return userRepository.save(user);
    }

    // ================= LOGIN =================

    public User login(LoginDTO request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Check encrypted password
        if (!passwordEncoder.matches(
                request.getPassword(),
                user.getPassword())) {

            throw new RuntimeException("Invalid credentials");
        }

        return user;
    }
}