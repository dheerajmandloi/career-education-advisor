package com.example.career_education_advisor.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.career_education_advisor.DTO.LoginDTO;
import com.example.career_education_advisor.DTO.RegisterDTO;
import com.example.career_education_advisor.Models.AccountStatus;
import com.example.career_education_advisor.Models.Role;
import com.example.career_education_advisor.Models.User;
import com.example.career_education_advisor.Repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // ================= STUDENT REGISTER =================

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

        // Student account is active
        user.setStatus(AccountStatus.APPROVED);

        return userRepository.save(user);
    }

    // ================= COUNSELOR REGISTER =================

    public User registerCounselor(RegisterDTO request) {

        // Email check
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        // Phone check
        if (userRepository.existsByPhone(request.getPhone())) {
            throw new RuntimeException("Phone already exists");
        }

        User counselor = new User();

        counselor.setName(request.getName());
        counselor.setEmail(request.getEmail());

        // Password encryption
        counselor.setPassword(
                passwordEncoder.encode(request.getPassword()));

        counselor.setPhone(request.getPhone());

        // Counselor registration
        counselor.setRole(Role.COUNSELOR);

        // Counselor must complete profile first
        counselor.setStatus(AccountStatus.PENDING_PROFILE);

        return userRepository.save(counselor);
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