package com.example.career_education_advisor.Services;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.example.career_education_advisor.DTO.AssessmentDTO;
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

        // =====================================================
        // COURSE RECOMMENDATION - PROFILE
        // =====================================================

        public RecommendationResponse recommendCourses(
                        StudentProfileDTO profile) {

                Map<String, Object> request = createRequest(profile);

                return restClient.post()
                                .uri("/recommend/courses")
                                .body(request)
                                .retrieve()
                                .body(RecommendationResponse.class);
        }

        // =====================================================
        // COURSE RECOMMENDATION - ASSESSMENT
        // =====================================================

        public RecommendationResponse recommendCourses(
                        AssessmentDTO assessment) {

                Map<String, Object> request = createRequest(assessment);

                return restClient.post()
                                .uri("/recommend/courses")
                                .body(request)
                                .retrieve()
                                .body(RecommendationResponse.class);
        }

        // =====================================================
        // COLLEGE RECOMMENDATION - PROFILE
        // =====================================================

        public RecommendationResponse recommendColleges(
                        StudentProfileDTO profile) {

                Map<String, Object> request = createRequest(profile);

                return restClient.post()
                                .uri("/recommend/colleges")
                                .body(request)
                                .retrieve()
                                .body(RecommendationResponse.class);
        }

        // =====================================================
        // COLLEGE RECOMMENDATION - ASSESSMENT
        // =====================================================

        public RecommendationResponse recommendColleges(
                        AssessmentDTO assessment) {

                Map<String, Object> request = createRequest(assessment);

                return restClient.post()
                                .uri("/recommend/colleges")
                                .body(request)
                                .retrieve()
                                .body(RecommendationResponse.class);
        }

        // =====================================================
        // CAREER RECOMMENDATION - PROFILE
        // =====================================================

        public RecommendationResponse recommendCareers(
                        StudentProfileDTO profile) {

                Map<String, Object> request = createRequest(profile);

                return restClient.post()
                                .uri("/recommend/careers")
                                .body(request)
                                .retrieve()
                                .body(RecommendationResponse.class);
        }

        // =====================================================
        // CAREER RECOMMENDATION - ASSESSMENT
        // =====================================================

        public RecommendationResponse recommendCareers(
                        AssessmentDTO assessment) {

                Map<String, Object> request = createRequest(assessment);

                return restClient.post()
                                .uri("/recommend/careers")
                                .body(request)
                                .retrieve()
                                .body(RecommendationResponse.class);
        }

        // =====================================================
        // CREATE REQUEST FROM STUDENT PROFILE
        // =====================================================

        private Map<String, Object> createRequest(
                        StudentProfileDTO profile) {

                Map<String, Object> request = new HashMap<>();

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

                request.put(
                                "career_interest",
                                safe(profile.getCareerInterest()));

                request.put(
                                "target_career",
                                safe(profile.getTargetCareer()));

                request.put(
                                "course_name",
                                safe(profile.getPreferredCourse()));

                request.put(
                                "preferred_course",
                                safe(profile.getPreferredCourse()));

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
                                "city",
                                safe(profile.getCity()));

                request.put(
                                "state",
                                safe(profile.getState()));

                request.put(
                                "preferred_location",
                                safe(profile.getPreferredLocation()));

                printRequest(request);

                return request;
        }

        // =====================================================
        // CREATE REQUEST FROM ASSESSMENT
        // =====================================================

        private Map<String, Object> createRequest(
                        AssessmentDTO assessment) {

                Map<String, Object> request = new HashMap<>();

                request.put(
                                "stream",
                                safe(assessment.getStream()));

                request.put(
                                "subjects",
                                assessment.getStrongSubjects() != null
                                                ? assessment.getStrongSubjects()
                                                : List.of());

                request.put(
                                "interests",
                                assessment.getInterests() != null
                                                ? assessment.getInterests()
                                                : List.of());

                request.put(
                                "skills",
                                assessment.getSkills() != null
                                                ? assessment.getSkills()
                                                : List.of());

                request.put(
                                "career_interest",
                                safe(assessment.getCareerPreference()));

                request.put(
                                "preferred_location",
                                safe(assessment.getPreferredLocation()));

                request.put(
                                "budget_range",
                                safe(assessment.getBudgetRange()));

                request.put(
                                "budget",
                                safe(assessment.getBudgetRange()));

                request.put(
                                "college_type",
                                safe(assessment.getCollegeType()));

                System.out.println(
                                "===== PYTHON ASSESSMENT REQUEST =====");

                System.out.println(request);

                System.out.println(
                                "======================================");

                return request;
        }

        // =====================================================
        // PRINT REQUEST
        // =====================================================

        private void printRequest(
                        Map<String, Object> request) {

                System.out.println(
                                "===== PYTHON PROFILE REQUEST =====");

                System.out.println(request);

                System.out.println(
                                "==================================");
        }

        // =====================================================
        // STRING NULL HANDLER
        // =====================================================

        private String safe(String value) {

                return value == null
                                ? ""
                                : value;
        }

        // =====================================================
        // STRING → LIST
        // =====================================================

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