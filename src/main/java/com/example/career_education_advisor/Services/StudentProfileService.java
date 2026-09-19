package com.example.career_education_advisor.Services;

import org.springframework.stereotype.Service;

import com.example.career_education_advisor.DTO.StudentProfileDTO;
import com.example.career_education_advisor.Models.StudentProfile;
import com.example.career_education_advisor.Models.User;
import com.example.career_education_advisor.Repositories.StudentProfileRepository;

@Service
public class StudentProfileService {

    private final StudentProfileRepository studentProfileRepository;

    public StudentProfileService(
            StudentProfileRepository studentProfileRepository) {

        this.studentProfileRepository = studentProfileRepository;
    }

    // Create or Update Student Profile
    public StudentProfileDTO saveProfile(
            User user,
            StudentProfileDTO dto) {

        StudentProfile profile = studentProfileRepository
                .findByUser(user)
                .orElse(new StudentProfile());

        profile.setUser(user);

        // Academic Details
        profile.setClassName(dto.getClassName());
        profile.setStream(dto.getStream());
        profile.setPercentage(dto.getPercentage());
        profile.setFavoriteSubjects(dto.getFavoriteSubjects());
        profile.setStrongSubjects(dto.getStrongSubjects());
        profile.setWeakSubjects(dto.getWeakSubjects());

        // Interest & Career Details
        profile.setInterests(dto.getInterests());
        profile.setSkills(dto.getSkills());
        profile.setCareerInterest(dto.getCareerInterest());
        profile.setTargetCareer(dto.getTargetCareer());

        // Course & College Preferences
        profile.setPreferredCourse(dto.getPreferredCourse());
        profile.setCollegeType(dto.getCollegeType());
        profile.setBudgetRange(dto.getBudgetRange());
        profile.setHostelRequired(dto.getHostelRequired());

        // Location
        profile.setCity(dto.getCity());
        profile.setState(dto.getState());
        profile.setPreferredLocation(dto.getPreferredLocation());

        StudentProfile savedProfile = studentProfileRepository.save(profile);

        return convertToDTO(savedProfile);
    }

    // Get Student Profile
    public StudentProfileDTO getProfile(User user) {

        StudentProfile profile = studentProfileRepository
                .findByUser(user)
                .orElseThrow(() -> new RuntimeException("Student profile not found"));

        return convertToDTO(profile);
    }

    // Convert Entity to DTO
    private StudentProfileDTO convertToDTO(
            StudentProfile profile) {

        StudentProfileDTO dto = new StudentProfileDTO();

        // Academic Details
        dto.setClassName(profile.getClassName());
        dto.setStream(profile.getStream());
        dto.setPercentage(profile.getPercentage());
        dto.setFavoriteSubjects(profile.getFavoriteSubjects());
        dto.setStrongSubjects(profile.getStrongSubjects());
        dto.setWeakSubjects(profile.getWeakSubjects());

        // Interest & Career Details
        dto.setInterests(profile.getInterests());
        dto.setSkills(profile.getSkills());
        dto.setCareerInterest(profile.getCareerInterest());
        dto.setTargetCareer(profile.getTargetCareer());

        // Course & College Preferences
        dto.setPreferredCourse(profile.getPreferredCourse());
        dto.setCollegeType(profile.getCollegeType());
        dto.setBudgetRange(profile.getBudgetRange());
        dto.setHostelRequired(profile.getHostelRequired());

        // Location
        dto.setCity(profile.getCity());
        dto.setState(profile.getState());
        dto.setPreferredLocation(profile.getPreferredLocation());

        return dto;
    }
}