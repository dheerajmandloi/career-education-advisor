package com.example.career_education_advisor.DTO;

import java.util.List;
import java.util.Map;

public class RecommendationResponse {

    private Map<String, Object> studentProfile;
    private List<Map<String, Object>> recommendations;

    public RecommendationResponse() {
    }

    public Map<String, Object> getStudentProfile() {
        return studentProfile;
    }

    public void setStudentProfile(Map<String, Object> studentProfile) {
        this.studentProfile = studentProfile;
    }

    public List<Map<String, Object>> getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(List<Map<String, Object>> recommendations) {
        this.recommendations = recommendations;
    }
}