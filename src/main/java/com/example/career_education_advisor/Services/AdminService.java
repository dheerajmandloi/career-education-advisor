package com.example.career_education_advisor.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.career_education_advisor.DTO.AdminDashboardDTO;
import com.example.career_education_advisor.DTO.AdminStudentDTO;
import com.example.career_education_advisor.DTO.AdminStudentProfileDTO;
import com.example.career_education_advisor.Models.Role;
import com.example.career_education_advisor.Models.StudentProfile;
import com.example.career_education_advisor.Models.User;
import com.example.career_education_advisor.Repositories.StudentProfileRepository;
import com.example.career_education_advisor.Repositories.UserRepository;

@Service
public class AdminService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StudentProfileRepository studentProfileRepository;

    // ================= DASHBOARD =================

    public AdminDashboardDTO getDashboardStats() {

        long totalStudents = userRepository.countByRole(Role.STUDENT);
        long totalCounselors = userRepository.countByRole(Role.COUNSELOR);
        long totalAdmins = userRepository.countByRole(Role.ADMIN);

        return new AdminDashboardDTO(
                totalStudents,
                totalCounselors,
                totalAdmins);
    }

    // ================= STUDENT MANAGEMENT =================

    public List<AdminStudentDTO> getAllStudents() {

        List<User> students = userRepository.findByRole(Role.STUDENT);

        return students.stream()
                .map(student -> new AdminStudentDTO(
                        student.getId(),
                        student.getName(),
                        student.getEmail(),
                        student.getPhone(),
                        student.getRole().name()))
                .collect(Collectors.toList());
    }

    // ================= STUDENT PROFILE =================

    public AdminStudentProfileDTO getStudentProfile(Long studentId) {

        // 1. Find student user
        User student = userRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        // 2. Verify that the user is actually a STUDENT
        if (student.getRole() != Role.STUDENT) {
            throw new RuntimeException("Selected user is not a student");
        }

        // 3. Find student's profile
        StudentProfile profile = studentProfileRepository
                .findByUserId(studentId)
                .orElse(null);

        // 4. If profile does not exist,
        // return basic user details and null profile fields
        if (profile == null) {

            return new AdminStudentProfileDTO(
                    student.getId(),
                    student.getName(),
                    student.getEmail(),
                    student.getPhone(),
                    student.getRole().name(),

                    null, // className
                    null, // stream
                    null, // percentage

                    null, // favoriteSubjects
                    null, // strongSubjects
                    null, // weakSubjects

                    null, // interests
                    null, // skills

                    null, // careerInterest
                    null, // targetCareer
                    null, // preferredCourse

                    null, // collegeType
                    null, // budgetRange
                    null, // hostelRequired

                    null, // city
                    null, // state
                    null // preferredLocation
            );
        }

        // 5. Profile exists - return complete student profile
        return new AdminStudentProfileDTO(

                // User Details
                student.getId(),
                student.getName(),
                student.getEmail(),
                student.getPhone(),
                student.getRole().name(),

                // Basic Information
                profile.getClassName(),
                profile.getStream(),
                profile.getPercentage(),

                // Academic Information
                profile.getFavoriteSubjects(),
                profile.getStrongSubjects(),
                profile.getWeakSubjects(),

                // Interest & Skills
                profile.getInterests(),
                profile.getSkills(),

                // Career Information
                profile.getCareerInterest(),
                profile.getTargetCareer(),
                profile.getPreferredCourse(),

                // College Preferences
                profile.getCollegeType(),
                profile.getBudgetRange(),
                profile.getHostelRequired(),

                // Location
                profile.getCity(),
                profile.getState(),
                profile.getPreferredLocation());
    }
}