package com.example.career_education_advisor.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.career_education_advisor.Models.Feedback;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

    // Get feedback by type
    // WEBSITE or COUNSELOR
    List<Feedback> findByFeedbackType(String feedbackType);
}