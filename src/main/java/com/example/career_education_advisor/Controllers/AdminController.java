package com.example.career_education_advisor.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.career_education_advisor.DTO.AdminDashboardDTO;
import com.example.career_education_advisor.DTO.AdminStudentDTO;
import com.example.career_education_advisor.DTO.AdminStudentProfileDTO;
import com.example.career_education_advisor.Services.AdminService;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // ================= ADMIN DASHBOARD =================

    @GetMapping("/dashboard")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<AdminDashboardDTO> getDashboard() {

        AdminDashboardDTO dashboard = adminService.getDashboardStats();

        return ResponseEntity.ok(dashboard);
    }

    // ================= STUDENT MANAGEMENT =================

    @GetMapping("/students")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<List<AdminStudentDTO>> getAllStudents() {

        List<AdminStudentDTO> students = adminService.getAllStudents();

        return ResponseEntity.ok(students);
    }

    // ================= STUDENT PROFILE =================

    @GetMapping("/students/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<AdminStudentProfileDTO> getStudentProfile(
            @PathVariable("id") Long id) {

        AdminStudentProfileDTO studentProfile = adminService.getStudentProfile(id);

        return ResponseEntity.ok(studentProfile);
    }
}