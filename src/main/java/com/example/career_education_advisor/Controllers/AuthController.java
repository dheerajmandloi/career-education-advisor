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
import com.example.career_education_advisor.Services.UserService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private Jwtutils jwtutils;

    // ================= REGISTER =================

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
                    user.getRole());

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
                    user.getRole());

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