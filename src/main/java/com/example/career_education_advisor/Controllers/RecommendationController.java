package com.example.career_education_advisor.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.career_education_advisor.DTO.RecommendationResponse;
import com.example.career_education_advisor.DTO.StudentProfileDTO;
import com.example.career_education_advisor.Services.RecommendationService;

@RestController
@RequestMapping("/api/recommendation")
@CrossOrigin(origins = "*")
public class RecommendationController {

    private final RecommendationService recommendationService;

    public RecommendationController(
            RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    // Course Recommendation
    @PostMapping("/courses")
    public ResponseEntity<RecommendationResponse> recommendCourses(
            @RequestBody StudentProfileDTO profile) {

        RecommendationResponse response = recommendationService.recommendCourses(profile);

        return ResponseEntity.ok(response);
    }

    // College Recommendation
    @PostMapping("/colleges")
    public ResponseEntity<RecommendationResponse> recommendColleges(
            @RequestBody StudentProfileDTO profile) {

        RecommendationResponse response = recommendationService.recommendColleges(profile);

        return ResponseEntity.ok(response);
    }

    // Career Recommendation
    @PostMapping("/careers")
    public ResponseEntity<RecommendationResponse> recommendCareers(
            @RequestBody StudentProfileDTO profile) {

        RecommendationResponse response = recommendationService.recommendCareers(profile);

        return ResponseEntity.ok(response);
    }
}