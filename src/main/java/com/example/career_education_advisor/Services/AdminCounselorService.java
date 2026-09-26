package com.example.career_education_advisor.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.career_education_advisor.DTO.AdminCounselorDTO;
import com.example.career_education_advisor.Models.AccountStatus;
import com.example.career_education_advisor.Models.CounselorProfile;
import com.example.career_education_advisor.Models.Role;
import com.example.career_education_advisor.Models.User;
import com.example.career_education_advisor.Repositories.CounselorProfileRepository;
import com.example.career_education_advisor.Repositories.UserRepository;

@Service
public class AdminCounselorService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CounselorProfileRepository counselorProfileRepository;

    // ================= PENDING COUNSELORS =================

    public List<AdminCounselorDTO> getPendingCounselors() {

        List<User> counselors = userRepository.findByRole(Role.COUNSELOR);

        List<AdminCounselorDTO> result = new ArrayList<>();

        for (User user : counselors) {

            if (user.getStatus() != AccountStatus.PENDING_REVIEW) {
                continue;
            }

            CounselorProfile profile = counselorProfileRepository
                    .findByUserId(user.getId())
                    .orElse(null);

            result.add(convertToDTO(user, profile));
        }

        return result;
    }

    // ================= GET COUNSELOR DETAILS =================

    public AdminCounselorDTO getCounselor(Long counselorId) {

        User user = userRepository.findById(counselorId)
                .orElseThrow(() -> new RuntimeException(
                        "Counselor not found"));

        if (user.getRole() != Role.COUNSELOR) {
            throw new RuntimeException(
                    "User is not a counselor");
        }

        CounselorProfile profile = counselorProfileRepository
                .findByUserId(counselorId)
                .orElse(null);

        return convertToDTO(user, profile);
    }

    // ================= APPROVE COUNSELOR =================

    public AdminCounselorDTO approveCounselor(
            Long counselorId) {

        User user = userRepository.findById(counselorId)
                .orElseThrow(() -> new RuntimeException(
                        "Counselor not found"));

        if (user.getRole() != Role.COUNSELOR) {
            throw new RuntimeException(
                    "User is not a counselor");
        }

        if (user.getStatus() != AccountStatus.PENDING_REVIEW) {
            throw new RuntimeException(
                    "Counselor is not pending review");
        }

        user.setStatus(AccountStatus.APPROVED);

        User savedUser = userRepository.save(user);

        CounselorProfile profile = counselorProfileRepository
                .findByUserId(counselorId)
                .orElse(null);

        return convertToDTO(savedUser, profile);
    }

    // ================= CONVERT TO DTO =================

    private AdminCounselorDTO convertToDTO(
            User user,
            CounselorProfile profile) {

        if (profile == null) {

            return new AdminCounselorDTO(
                    user.getId(),
                    user.getName(),
                    user.getEmail(),
                    user.getPhone(),
                    user.getStatus(),
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null);
        }

        return new AdminCounselorDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPhone(),
                user.getStatus(),

                profile.getId(),
                profile.getHighestQualification(),
                profile.getUniversityInstitute(),
                profile.getSpecialization(),
                profile.getExperienceYears(),
                profile.getAreasOfExpertise(),
                profile.getProfessionalExperienceDetails(),
                profile.getQualificationProof(),
                profile.getResume());
    }

    public List<AdminCounselorDTO> getAllCounselors() {

        List<User> counselors = userRepository.findByRole(Role.COUNSELOR);

        List<AdminCounselorDTO> result = new ArrayList<>();

        for (User user : counselors) {

            CounselorProfile profile = counselorProfileRepository
                    .findByUserId(user.getId())
                    .orElse(null);

            result.add(
                    convertToDTO(user, profile));
        }

        return result;
    }

    public AdminCounselorDTO rejectCounselor(Long counselorId) {

        User user = userRepository.findById(counselorId)
                .orElseThrow(() -> new RuntimeException("Counselor not found"));

        if (user.getRole() != Role.COUNSELOR) {
            throw new RuntimeException("User is not a counselor");
        }

        if (user.getStatus() != AccountStatus.PENDING_REVIEW) {
            throw new RuntimeException("Counselor is not pending review");
        }

        user.setStatus(AccountStatus.REJECTED);

        User savedUser = userRepository.save(user);

        CounselorProfile profile = counselorProfileRepository
                .findByUserId(counselorId)
                .orElse(null);

        return convertToDTO(savedUser, profile);
    }
}