package com.example.career_education_advisor.Services;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.example.career_education_advisor.DTO.RecommendationResponse;
import com.example.career_education_advisor.DTO.StudentProfileDTO;

@Service
public class RecommendationService {

    private final RestClient restClient;

    public RecommendationService(RestClient.Builder restClientBuilder) {

        this.restClient = restClientBuilder
                .baseUrl("http://127.0.0.1:8000")
                .build();
    }

    // ==============================
    // COURSE RECOMMENDATION
    // ==============================

    public RecommendationResponse recommendCourses(
            StudentProfileDTO profile) {

        Map<String, Object> request = createRequest(profile);

        return restClient.post()
                .uri("/recommend/courses")
                .body(request)
                .retrieve()
                .body(RecommendationResponse.class);
    }

    // ==============================
    // COLLEGE RECOMMENDATION
    // ==============================

    public RecommendationResponse recommendColleges(
            StudentProfileDTO profile) {

        Map<String, Object> request = createRequest(profile);

        return restClient.post()
                .uri("/recommend/colleges")
                .body(request)
                .retrieve()
                .body(RecommendationResponse.class);
    }

    // ==============================
    // CAREER RECOMMENDATION
    // ==============================

    public RecommendationResponse recommendCareers(
            StudentProfileDTO profile) {

        Map<String, Object> request = createRequest(profile);

        return restClient.post()
                .uri("/recommend/careers")
                .body(request)
                .retrieve()
                .body(RecommendationResponse.class);
    }

    // ==============================
    // CREATE PYTHON REQUEST
    // ==============================

    private Map<String, Object> createRequest(
            StudentProfileDTO profile) {

        Map<String, Object> request = new HashMap<>();

        // Academic information

        request.put(
                "stream",
                safe(profile.getStream()));

        request.put(
                "percentage",
                profile.getPercentage());

        request.put(
                "subjects",
                convertToList(
                        profile.getStrongSubjects()));

        request.put(
                "favorite_subjects",
                convertToList(
                        profile.getFavoriteSubjects()));

        request.put(
                "interests",
                convertToList(
                        profile.getInterests()));

        request.put(
                "skills",
                convertToList(
                        profile.getSkills()));

        // Career information

        request.put(
                "career_interest",
                safe(profile.getCareerInterest()));

        request.put(
                "target_career",
                safe(profile.getTargetCareer()));

        // Course

        request.put(
                "course_name",
                safe(profile.getPreferredCourse()));

        request.put(
                "preferred_course",
                safe(profile.getPreferredCourse()));

        // College preferences

        request.put(
                "college_type",
                safe(profile.getCollegeType()));

        request.put(
                "budget",
                safe(profile.getBudgetRange()));

        request.put(
                "budget_range",
                safe(profile.getBudgetRange()));

        request.put(
                "hostel_required",
                safe(profile.getHostelRequired()));

        request.put(
                "city",
                safe(profile.getCity()));

        request.put(
                "state",
                safe(profile.getState()));

        request.put(
                "preferred_location",
                safe(profile.getPreferredLocation()));

        System.out.println(
                "===== PYTHON REQUEST =====");

        System.out.println(request);

        System.out.println(
                "==========================");

        return request;
    }

    // ==============================
    // STRING NULL HANDLER
    // ==============================

    private String safe(String value) {

        return value == null
                ? ""
                : value;
    }

    // ==============================
    // STRING → LIST
    // ==============================

    private List<String> convertToList(
            String value) {

        if (value == null
                || value.trim().isEmpty()) {

            return List.of();
        }

        return Arrays.stream(
                value.split(","))
                .map(String::trim)
                .filter(
                        item -> !item.isEmpty())
                .collect(
                        Collectors.toList());
    }

}