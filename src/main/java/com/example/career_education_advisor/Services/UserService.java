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

    @Autowired
    private OtpService otpService;

    // ================= STUDENT REGISTER =================

    public User register(RegisterDTO request) {

        // ================= OTP CHECK =================

        if (!otpService.isEmailVerified(request.getEmail())) {
            throw new RuntimeException(
                    "Please verify your email with OTP before registration");
        }

        // ================= EMAIL CHECK =================

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        // ================= PHONE CHECK =================

        if (userRepository.existsByPhone(request.getPhone())) {
            throw new RuntimeException("Phone already exists");
        }

        // ================= CREATE USER =================

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

        User savedUser = userRepository.save(user);

        // OTP verification complete hone ke baad remove
        otpService.removeVerifiedEmail(request.getEmail());

        return savedUser;
    }

    // ================= COUNSELOR REGISTER =================

    public User registerCounselor(RegisterDTO request) {

        // ================= OTP CHECK =================

        if (!otpService.isEmailVerified(request.getEmail())) {
            throw new RuntimeException(
                    "Please verify your email with OTP before registration");
        }

        // ================= EMAIL CHECK =================

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        // ================= PHONE CHECK =================

        if (userRepository.existsByPhone(request.getPhone())) {
            throw new RuntimeException("Phone already exists");
        }

        // ================= CREATE COUNSELOR =================

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

        User savedCounselor = userRepository.save(counselor);

        // OTP verification complete hone ke baad remove
        otpService.removeVerifiedEmail(request.getEmail());

        return savedCounselor;
    }

    // ================= LOGIN =================

    public User login(LoginDTO request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(
                request.getPassword(),
                user.getPassword())) {

            throw new RuntimeException("Invalid credentials");
        }

        return user;
    }
}