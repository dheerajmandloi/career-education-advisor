package com.example.career_education_advisor.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.career_education_advisor.DTO.AssessmentDTO;
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

    // =====================================================
    // COURSE RECOMMENDATION - PROFILE
    // =====================================================

    @PostMapping("/courses")
    public ResponseEntity<RecommendationResponse> recommendCourses(
            @RequestBody StudentProfileDTO profile) {

        RecommendationResponse response = recommendationService.recommendCourses(profile);

        return ResponseEntity.ok(response);
    }

    // =====================================================
    // COLLEGE RECOMMENDATION - PROFILE
    // =====================================================

    @PostMapping("/colleges")
    public ResponseEntity<RecommendationResponse> recommendColleges(
            @RequestBody StudentProfileDTO profile) {

        RecommendationResponse response = recommendationService.recommendColleges(profile);

        return ResponseEntity.ok(response);
    }

    // =====================================================
    // CAREER RECOMMENDATION - PROFILE
    // =====================================================

    @PostMapping("/careers")
    public ResponseEntity<RecommendationResponse> recommendCareers(
            @RequestBody StudentProfileDTO profile) {

        RecommendationResponse response = recommendationService.recommendCareers(profile);

        return ResponseEntity.ok(response);
    }

    // =====================================================
    // COURSE RECOMMENDATION - ASSESSMENT
    // =====================================================

    @PostMapping("/assessment/courses")
    public ResponseEntity<RecommendationResponse> recommendCoursesFromAssessment(
            @RequestBody AssessmentDTO assessment) {

        RecommendationResponse response = recommendationService.recommendCourses(assessment);

        return ResponseEntity.ok(response);
    }

    // =====================================================
    // COLLEGE RECOMMENDATION - ASSESSMENT
    // =====================================================

    @PostMapping("/assessment/colleges")
    public ResponseEntity<RecommendationResponse> recommendCollegesFromAssessment(
            @RequestBody AssessmentDTO assessment) {

        RecommendationResponse response = recommendationService.recommendColleges(assessment);

        return ResponseEntity.ok(response);
    }

    // =====================================================
    // CAREER RECOMMENDATION - ASSESSMENT
    // =====================================================

    @PostMapping("/assessment/careers")
    public ResponseEntity<RecommendationResponse> recommendCareersFromAssessment(
            @RequestBody AssessmentDTO assessment) {

        RecommendationResponse response = recommendationService.recommendCareers(assessment);

        return ResponseEntity.ok(response);
    }
}