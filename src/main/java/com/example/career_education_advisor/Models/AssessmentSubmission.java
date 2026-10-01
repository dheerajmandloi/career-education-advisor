package com.example.career_education_advisor.Models;

import java.util.Map;

public class AssessmentSubmission {

    private String classGroup; // 9_10 or 11_12
    private String stream; // PCB, PCM, Commerce, Arts
    private Map<String, String> answers;

    public String getClassGroup() {
        return classGroup;
    }

    public void setClassGroup(String classGroup) {
        this.classGroup = classGroup;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public Map<String, String> getAnswers() {
        return answers;
    }

    public void setAnswers(Map<String, String> answers) {
        this.answers = answers;
    }
}