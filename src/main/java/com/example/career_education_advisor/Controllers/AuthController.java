package com.example.career_education_advisor.Controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.career_education_advisor.Config.Jwtutils;
import com.example.career_education_advisor.DTO.LoginDTO;
import com.example.career_education_advisor.DTO.RegisterDTO;
import com.example.career_education_advisor.DTO.UserDTO;
import com.example.career_education_advisor.Models.User;
import com.example.career_education_advisor.Services.EmailService;
import com.example.career_education_advisor.Services.OtpService;
import com.example.career_education_advisor.Services.UserService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private Jwtutils jwtutils;

    @Autowired
    private OtpService otpService;

    @Autowired
    private EmailService emailService;

    // ================= SEND OTP =================

    @PostMapping("/send-otp")
    public ResponseEntity<?> sendOtp(
            @RequestBody Map<String, String> request) {

        try {

            String email = request.get("email");

            if (email == null || email.trim().isEmpty()) {
                return ResponseEntity
                        .badRequest()
                        .body("Email is required");
            }

            String otp = otpService.generateOtp();

            otpService.saveOtp(email, otp);

            emailService.sendOtp(email, otp);

            return ResponseEntity.ok(
                    "OTP sent successfully to your email");

        } catch (Exception e) {

            return ResponseEntity
                    .badRequest()
                    .body("Failed to send OTP: " + e.getMessage());
        }
    }

    // ================= VERIFY OTP =================

    @PostMapping("/verify-otp")
    public ResponseEntity<?> verifyOtp(
            @RequestBody Map<String, String> request) {

        try {

            String email = request.get("email");
            String otp = request.get("otp");

            if (email == null || email.trim().isEmpty()) {
                return ResponseEntity
                        .badRequest()
                        .body("Email is required");
            }

            if (otp == null || otp.trim().isEmpty()) {
                return ResponseEntity
                        .badRequest()
                        .body("OTP is required");
            }

            boolean verified = otpService.verifyOtp(email, otp);

            if (!verified) {

                return ResponseEntity
                        .badRequest()
                        .body("Invalid or expired OTP");
            }

            return ResponseEntity.ok(
                    "Email verified successfully");

        } catch (Exception e) {

            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());
        }
    }

    // ================= STUDENT REGISTER =================

    @PostMapping("/register")
    public ResponseEntity<?> register(
            @RequestBody RegisterDTO request) {

        try {

            User user = userService.register(request);

            UserDTO response = new UserDTO(
                    user.getId(),
                    user.getName(),
                    user.getEmail(),
                    user.getPhone(),
                    user.getRole(),
                    user.getStatus());

            return ResponseEntity.ok(response);

        } catch (RuntimeException e) {

            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());
        }
    }

    // ================= COUNSELOR REGISTER =================

    @PostMapping("/register-counselor")
    public ResponseEntity<?> registerCounselor(
            @RequestBody RegisterDTO request) {

        try {

            User counselor = userService.registerCounselor(request);

            UserDTO response = new UserDTO(
                    counselor.getId(),
                    counselor.getName(),
                    counselor.getEmail(),
                    counselor.getPhone(),
                    counselor.getRole(),
                    counselor.getStatus());

            return ResponseEntity.ok(response);

        } catch (RuntimeException e) {

            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());
        }
    }

    // ================= LOGIN =================

    @PostMapping("/login")
    public ResponseEntity<?> login(
            @RequestBody LoginDTO request) {

        try {

            User user = userService.login(request);

            String token = jwtutils.generateToken(
                    user.getEmail(),
                    user.getRole().name());

            UserDTO userDTO = new UserDTO(
                    user.getId(),
                    user.getName(),
                    user.getEmail(),
                    user.getPhone(),
                    user.getRole(),
                    user.getStatus());

            Map<String, Object> response = new HashMap<>();

            response.put("token", token);
            response.put("user", userDTO);

            return ResponseEntity.ok(response);

        } catch (RuntimeException e) {

            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());
        }
    }
}