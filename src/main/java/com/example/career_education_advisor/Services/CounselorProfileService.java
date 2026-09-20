package com.example.career_education_advisor.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.career_education_advisor.DTO.CounselorProfileDTO;
import com.example.career_education_advisor.Models.AccountStatus;
import com.example.career_education_advisor.Models.CounselorProfile;
import com.example.career_education_advisor.Models.Role;
import com.example.career_education_advisor.Models.User;
import com.example.career_education_advisor.Repositories.CounselorProfileRepository;
import com.example.career_education_advisor.Repositories.UserRepository;

@Service
public class CounselorProfileService {

    @Autowired
    private CounselorProfileRepository counselorProfileRepository;

    @Autowired
    private UserRepository userRepository;

    // ================= CREATE / UPDATE PROFILE =================

    public CounselorProfileDTO saveProfile(
            Long userId,
            CounselorProfileDTO request) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Only COUNSELOR can create counselor profile
        if (user.getRole() != Role.COUNSELOR) {
            throw new RuntimeException(
                    "Only counselors can create counselor profile");
        }

        CounselorProfile profile = counselorProfileRepository
                .findByUserId(userId)
                .orElse(new CounselorProfile());

        profile.setUser(user);

        profile.setHighestQualification(
                request.getHighestQualification());

        profile.setUniversityInstitute(
                request.getUniversityInstitute());

        profile.setSpecialization(
                request.getSpecialization());

        profile.setExperienceYears(
                request.getExperienceYears());

        profile.setAreasOfExpertise(
                request.getAreasOfExpertise());

        profile.setProfessionalExperienceDetails(
                request.getProfessionalExperienceDetails());

        profile.setQualificationProof(
                request.getQualificationProof());

        profile.setResume(
                request.getResume());

        CounselorProfile savedProfile = counselorProfileRepository.save(profile);

        return convertToDTO(savedProfile);
    }

    // ================= SUBMIT FOR REVIEW =================

    public CounselorProfileDTO submitForReview(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (user.getRole() != Role.COUNSELOR) {
            throw new RuntimeException(
                    "Only counselors can submit profile");
        }

        CounselorProfile profile = counselorProfileRepository
                .findByUserId(userId)
                .orElseThrow(() -> new RuntimeException(
                        "Please complete your profile first"));

        // Basic validation
        if (profile.getHighestQualification() == null
                || profile.getUniversityInstitute() == null
                || profile.getSpecialization() == null
                || profile.getExperienceYears() == null
                || profile.getAreasOfExpertise() == null) {

            throw new RuntimeException(
                    "Please complete all required profile details");
        }

        // Send profile to admin
        user.setStatus(AccountStatus.PENDING_REVIEW);

        userRepository.save(user);

        return convertToDTO(profile);
    }

    // ================= GET PROFILE =================

    public CounselorProfileDTO getProfile(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (user.getRole() != Role.COUNSELOR) {
            throw new RuntimeException(
                    "Only counselors can access this profile");
        }

        CounselorProfile profile = counselorProfileRepository
                .findByUserId(userId)
                .orElseThrow(() -> new RuntimeException(
                        "Counselor profile not found"));

        return convertToDTO(profile);
    }

    // ================= CONVERT ENTITY TO DTO =================

    private CounselorProfileDTO convertToDTO(
            CounselorProfile profile) {

        User user = profile.getUser();

        return new CounselorProfileDTO(
                profile.getId(),
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPhone(),
                profile.getHighestQualification(),
                profile.getUniversityInstitute(),
                profile.getSpecialization(),
                profile.getExperienceYears(),
                profile.getAreasOfExpertise(),
                profile.getProfessionalExperienceDetails(),
                profile.getQualificationProof(),
                profile.getResume());
    }
}