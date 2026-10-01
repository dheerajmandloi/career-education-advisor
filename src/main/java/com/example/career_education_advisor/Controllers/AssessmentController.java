package com.example.career_education_advisor.Controllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.career_education_advisor.Models.AssessmentSubmission;
import com.example.career_education_advisor.Services.AssessmentService;

@RestController
@RequestMapping("/api/assessment")
@CrossOrigin(origins = "*")
public class AssessmentController {

    private final AssessmentService assessmentService;

    public AssessmentController(AssessmentService assessmentService) {
        this.assessmentService = assessmentService;
    }

    @PostMapping("/submit")
    public ResponseEntity<?> submitAssessment(
            @RequestBody AssessmentSubmission submission) {

        Map<String, Object> result = assessmentService.processAssessment(submission);

        return ResponseEntity.ok(result);
    }
}