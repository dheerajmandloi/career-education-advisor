package com.example.career_education_advisor.Models;

import java.util.List;

public class Assessment {

    private String stream;

    private List<String> strongSubjects;

    private List<String> interests;

    private List<String> skills;

    private String careerPreference;

    private String preferredLocation;

    private String budgetRange;

    private String collegeType;

    // Getters and Setters

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public List<String> getStrongSubjects() {
        return strongSubjects;
    }

    public void setStrongSubjects(List<String> strongSubjects) {
        this.strongSubjects = strongSubjects;
    }

    public List<String> getInterests() {
        return interests;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public String getCareerPreference() {
        return careerPreference;
    }

    public void setCareerPreference(String careerPreference) {
        this.careerPreference = careerPreference;
    }

    public String getPreferredLocation() {
        return preferredLocation;
    }

    public void setPreferredLocation(String preferredLocation) {
        this.preferredLocation = preferredLocation;
    }

    public String getBudgetRange() {
        return budgetRange;
    }

    public void setBudgetRange(String budgetRange) {
        this.budgetRange = budgetRange;
    }

    public String getCollegeType() {
        return collegeType;
    }

    public void setCollegeType(String collegeType) {
        this.collegeType = collegeType;
    }
}