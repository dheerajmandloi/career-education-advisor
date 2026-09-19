package com.example.career_education_advisor.DTO;

public class StudentProfileDTO {

    // Academic Details
    private String className;
    private String stream;
    private Double percentage;
    private String favoriteSubjects;
    private String strongSubjects;
    private String weakSubjects;

    // Interest & Career Details
    private String interests;
    private String skills;
    private String careerInterest;
    private String targetCareer;

    // Course & College Preferences
    private String preferredCourse;
    private String collegeType;
    private String budgetRange;
    private String hostelRequired;

    // Location
    private String city;
    private String state;
    private String preferredLocation;

    // Default constructor
    public StudentProfileDTO() {
    }

    // Getters and Setters

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    public String getFavoriteSubjects() {
        return favoriteSubjects;
    }

    public void setFavoriteSubjects(String favoriteSubjects) {
        this.favoriteSubjects = favoriteSubjects;
    }

    public String getStrongSubjects() {
        return strongSubjects;
    }

    public void setStrongSubjects(String strongSubjects) {
        this.strongSubjects = strongSubjects;
    }

    public String getWeakSubjects() {
        return weakSubjects;
    }

    public void setWeakSubjects(String weakSubjects) {
        this.weakSubjects = weakSubjects;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getCareerInterest() {
        return careerInterest;
    }

    public void setCareerInterest(String careerInterest) {
        this.careerInterest = careerInterest;
    }

    public String getTargetCareer() {
        return targetCareer;
    }

    public void setTargetCareer(String targetCareer) {
        this.targetCareer = targetCareer;
    }

    public String getPreferredCourse() {
        return preferredCourse;
    }

    public void setPreferredCourse(String preferredCourse) {
        this.preferredCourse = preferredCourse;
    }

    public String getCollegeType() {
        return collegeType;
    }

    public void setCollegeType(String collegeType) {
        this.collegeType = collegeType;
    }

    public String getBudgetRange() {
        return budgetRange;
    }

    public void setBudgetRange(String budgetRange) {
        this.budgetRange = budgetRange;
    }

    public String getHostelRequired() {
        return hostelRequired;
    }

    public void setHostelRequired(String hostelRequired) {
        this.hostelRequired = hostelRequired;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPreferredLocation() {
        return preferredLocation;
    }

    public void setPreferredLocation(String preferredLocation) {
        this.preferredLocation = preferredLocation;
    }
}