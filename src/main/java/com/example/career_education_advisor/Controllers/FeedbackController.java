package com.example.career_education_advisor.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.career_education_advisor.DTO.FeedbackDTO;
import com.example.career_education_advisor.Models.Feedback;
import com.example.career_education_advisor.Services.FeedbackService;

@RestController
@RequestMapping("/api/feedback")
@CrossOrigin(origins = "*")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    // Add Website Feedback
    @PostMapping
    public ResponseEntity<?> addFeedback(@RequestBody FeedbackDTO dto) {

        try {

            Feedback feedback = feedbackService.addFeedback(dto);

            return ResponseEntity.ok(feedback);

        } catch (Exception e) {

            return ResponseEntity
                    .status(500)
                    .body("Error adding feedback: " + e.getMessage());
        }
    }

    // Get All Website Feedback
    @GetMapping
    public ResponseEntity<List<Feedback>> getAllFeedbacks() {

        return ResponseEntity.ok(
                feedbackService.getAllFeedbacks());
    }

    // Delete Feedback
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFeedback(@PathVariable Long id) {

        try {

            feedbackService.deleteFeedback(id);

            return ResponseEntity.ok(
                    "Feedback deleted successfully");

        } catch (Exception e) {

            return ResponseEntity
                    .status(500)
                    .body("Error deleting feedback: " + e.getMessage());
        }
    }
}