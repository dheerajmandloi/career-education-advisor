package com.example.career_education_advisor.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.career_education_advisor.DTO.AdminCounselorDTO;
import com.example.career_education_advisor.Services.AdminCounselorService;

@RestController
@RequestMapping("/api/admin/counselors")
@CrossOrigin(origins = "*")
public class AdminCounselorController {

    @Autowired
    private AdminCounselorService adminCounselorService;

    // ================= GET PENDING COUNSELORS =================

    @GetMapping("/pending")
    public ResponseEntity<?> getPendingCounselors() {

        try {

            List<AdminCounselorDTO> counselors = adminCounselorService
                    .getPendingCounselors();

            return ResponseEntity.ok(counselors);

        } catch (RuntimeException e) {

            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());
        }
    }

    // ================= GET COUNSELOR DETAILS =================

    @GetMapping("/{counselorId}")
    public ResponseEntity<?> getCounselor(
            @PathVariable Long counselorId) {

        try {

            AdminCounselorDTO counselor = adminCounselorService
                    .getCounselor(counselorId);

            return ResponseEntity.ok(counselor);

        } catch (RuntimeException e) {

            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllCounselors() {

        try {

            List<AdminCounselorDTO> counselors = adminCounselorService.getAllCounselors();

            return ResponseEntity.ok(counselors);

        } catch (RuntimeException e) {

            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());
        }
    }

    @PutMapping("/{counselorId}/reject")
    public ResponseEntity<?> rejectCounselor(
            @PathVariable Long counselorId) {

        try {

            AdminCounselorDTO counselor = adminCounselorService
                    .rejectCounselor(counselorId);

            return ResponseEntity.ok(counselor);

        } catch (RuntimeException e) {

            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());
        }
    }
    // ================= APPROVE COUNSELOR =================

    @PutMapping("/{counselorId}/approve")
    public ResponseEntity<?> approveCounselor(
            @PathVariable Long counselorId) {

        try {

            AdminCounselorDTO counselor = adminCounselorService
                    .approveCounselor(counselorId);

            return ResponseEntity.ok(counselor);

        } catch (RuntimeException e) {

            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());
        }
    }
}