package com.example.career_education_advisor.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.career_education_advisor.DTO.CounselorProfileDTO;
import com.example.career_education_advisor.Services.CounselorProfileService;

@RestController
@RequestMapping("/api/counselor/profile")
@CrossOrigin(origins = "*")
public class CounselorProfileController {

    @Autowired
    private CounselorProfileService counselorProfileService;

    // ================= GET PROFILE =================

    @GetMapping("/{userId}")
    public ResponseEntity<?> getProfile(
            @PathVariable Long userId) {

        try {

            CounselorProfileDTO profile = counselorProfileService.getProfile(userId);

            return ResponseEntity.ok(profile);

        } catch (RuntimeException e) {

            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());
        }
    }

    // ================= SAVE / UPDATE PROFILE =================

    @PostMapping("/{userId}")
    public ResponseEntity<?> saveProfile(
            @PathVariable Long userId,
            @RequestBody CounselorProfileDTO request) {

        try {

            CounselorProfileDTO profile = counselorProfileService.saveProfile(
                    userId,
                    request);

            return ResponseEntity.ok(profile);

        } catch (RuntimeException e) {

            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());
        }
    }

    // ================= SUBMIT FOR REVIEW =================

    @PutMapping("/{userId}/submit")
    public ResponseEntity<?> submitForReview(
            @PathVariable Long userId) {

        try {

            CounselorProfileDTO profile = counselorProfileService.submitForReview(
                    userId);

            return ResponseEntity.ok(profile);

        } catch (RuntimeException e) {

            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());
        }
    }
}