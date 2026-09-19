package com.example.career_education_advisor.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.career_education_advisor.Models.StudentProfile;
import com.example.career_education_advisor.Models.User;

public interface StudentProfileRepository extends JpaRepository<StudentProfile, Long> {

    Optional<StudentProfile> findByUser(User user);

    boolean existsByUser(User user);
}