package com.example.career_education_advisor.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.career_education_advisor.Models.CounselorProfile;
import com.example.career_education_advisor.Models.User;

public interface CounselorProfileRepository extends JpaRepository<CounselorProfile, Long> {

    Optional<CounselorProfile> findByUser(User user);

    Optional<CounselorProfile> findByUserId(Long userId);
}