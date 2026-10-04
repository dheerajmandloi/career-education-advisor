package com.example.career_education_advisor.Services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.career_education_advisor.DTO.FeedbackDTO;
import com.example.career_education_advisor.Models.Feedback;
import com.example.career_education_advisor.Repositories.FeedbackRepository;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    // Add Website Feedback
    public Feedback addFeedback(FeedbackDTO dto) {

        Feedback feedback = new Feedback();

        feedback.setName(dto.getName());
        feedback.setEmail(dto.getEmail());
        feedback.setRating(dto.getRating());
        feedback.setComment(dto.getComment());

        // Backend automatically sets feedback type
        feedback.setFeedbackType("WEBSITE");

        feedback.setTimestamp(LocalDateTime.now());

        return feedbackRepository.save(feedback);
    }

    // Get All Feedback
    public List<Feedback> getAllFeedbacks() {
        return feedbackRepository.findAll();
    }

    // Delete Feedback
    public void deleteFeedback(Long id) {
        feedbackRepository.deleteById(id);
    }
}