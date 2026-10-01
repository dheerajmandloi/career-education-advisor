package com.example.career_education_advisor.Services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.career_education_advisor.Models.AssessmentSubmission;

@Service
public class AssessmentService {

    public Map<String, Object> processAssessment(
            AssessmentSubmission submission) {

        Map<String, Integer> scores = new HashMap<>();

        if (submission.getAnswers() != null) {
            for (String answer : submission.getAnswers().values()) {

                if (answer == null) {
                    continue;
                }

                String category = answer.toLowerCase();

                scores.put(
                        category,
                        scores.getOrDefault(category, 0) + 1);
            }
        }

        String topCategory = scores.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("general");

        Map<String, Object> result = new HashMap<>();

        result.put("classGroup", submission.getClassGroup());
        result.put("stream", submission.getStream());
        result.put("scores", scores);
        result.put("topCategory", topCategory);
        result.put(
                "message",
                "Assessment submitted successfully");

        return result;
    }
}