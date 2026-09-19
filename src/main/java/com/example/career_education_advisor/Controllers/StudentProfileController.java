package com.example.career_education_advisor.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.career_education_advisor.DTO.StudentProfileDTO;
import com.example.career_education_advisor.Models.User;
import com.example.career_education_advisor.Services.StudentProfileService;

@RestController
@RequestMapping("/api/student/profile")
@CrossOrigin(origins = "*")
public class StudentProfileController {

    private final StudentProfileService studentProfileService;

    public StudentProfileController(
            StudentProfileService studentProfileService) {

        this.studentProfileService = studentProfileService;
    }

    @PostMapping
    public ResponseEntity<StudentProfileDTO> saveProfile(
            @RequestBody StudentProfileDTO dto,
            Authentication authentication) {

        User user = (User) authentication.getPrincipal();

        StudentProfileDTO savedProfile = studentProfileService.saveProfile(user, dto);

        return ResponseEntity.ok(savedProfile);
    }

    @GetMapping
    public ResponseEntity<StudentProfileDTO> getProfile(
            Authentication authentication) {

        User user = (User) authentication.getPrincipal();

        StudentProfileDTO profile = studentProfileService.getProfile(user);

        return ResponseEntity.ok(profile);
    }
}