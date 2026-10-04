package com.example.career_education_advisor.Models;

import java.util.Map;

public class AssessmentSubmission {

    private String classGroup;

    private String stream;

    /*
     * Key = Question ID
     * Value = Selected option (A/B/C/D)
     *
     * Example:
     *
     * {
     * "1": "A",
     * "2": "C",
     * "3": "B"
     * }
     */
    private Map<String, String> answers;

    // =========================
    // GETTERS
    // =========================

    public String getClassGroup() {
        return classGroup;
    }

    public String getStream() {
        return stream;
    }

    public Map<String, String> getAnswers() {
        return answers;
    }

    // =========================
    // SETTERS
    // =========================

    public void setClassGroup(String classGroup) {
        this.classGroup = classGroup;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public void setAnswers(
            Map<String, String> answers) {

        this.answers = answers;
    }
}