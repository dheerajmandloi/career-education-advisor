package com.example.career_education_advisor.DTO;

public class AdminStudentProfileDTO {

    // ================= USER DETAILS =================

    private Long id;
    private String name;
    private String email;
    private String phone;
    private String role;

    // ================= STUDENT PROFILE =================

    private String className;
    private String stream;
    private Double percentage;

    private String favoriteSubjects;
    private String strongSubjects;
    private String weakSubjects;

    private String interests;
    private String skills;

    private String careerInterest;
    private String targetCareer;
    private String preferredCourse;

    private String collegeType;
    private String budgetRange;
    private String hostelRequired;

    private String city;
    private String state;
    private String preferredLocation;

    // ================= CONSTRUCTOR =================

    public AdminStudentProfileDTO() {
    }

    public AdminStudentProfileDTO(
            Long id,
            String name,
            String email,
            String phone,
            String role,
            String className,
            String stream,
            Double percentage,
            String favoriteSubjects,
            String strongSubjects,
            String weakSubjects,
            String interests,
            String skills,
            String careerInterest,
            String targetCareer,
            String preferredCourse,
            String collegeType,
            String budgetRange,
            String hostelRequired,
            String city,
            String state,
            String preferredLocation) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.role = role;

        this.className = className;
        this.stream = stream;
        this.percentage = percentage;

        this.favoriteSubjects = favoriteSubjects;
        this.strongSubjects = strongSubjects;
        this.weakSubjects = weakSubjects;

        this.interests = interests;
        this.skills = skills;

        this.careerInterest = careerInterest;
        this.targetCareer = targetCareer;
        this.preferredCourse = preferredCourse;

        this.collegeType = collegeType;
        this.budgetRange = budgetRange;
        this.hostelRequired = hostelRequired;

        this.city = city;
        this.state = state;
        this.preferredLocation = preferredLocation;
    }

    // ================= GETTERS =================

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getRole() {
        return role;
    }

    public String getClassName() {
        return className;
    }

    public String getStream() {
        return stream;
    }

    public Double getPercentage() {
        return percentage;
    }

    public String getFavoriteSubjects() {
        return favoriteSubjects;
    }

    public String getStrongSubjects() {
        return strongSubjects;
    }

    public String getWeakSubjects() {
        return weakSubjects;
    }

    public String getInterests() {
        return interests;
    }

    public String getSkills() {
        return skills;
    }

    public String getCareerInterest() {
        return careerInterest;
    }

    public String getTargetCareer() {
        return targetCareer;
    }

    public String getPreferredCourse() {
        return preferredCourse;
    }

    public String getCollegeType() {
        return collegeType;
    }

    public String getBudgetRange() {
        return budgetRange;
    }

    public String getHostelRequired() {
        return hostelRequired;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPreferredLocation() {
        return preferredLocation;
    }

    // ================= SETTERS =================

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    public void setFavoriteSubjects(String favoriteSubjects) {
        this.favoriteSubjects = favoriteSubjects;
    }

    public void setStrongSubjects(String strongSubjects) {
        this.strongSubjects = strongSubjects;
    }

    public void setWeakSubjects(String weakSubjects) {
        this.weakSubjects = weakSubjects;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public void setCareerInterest(String careerInterest) {
        this.careerInterest = careerInterest;
    }

    public void setTargetCareer(String targetCareer) {
        this.targetCareer = targetCareer;
    }

    public void setPreferredCourse(String preferredCourse) {
        this.preferredCourse = preferredCourse;
    }

    public void setCollegeType(String collegeType) {
        this.collegeType = collegeType;
    }

    public void setBudgetRange(String budgetRange) {
        this.budgetRange = budgetRange;
    }

    public void setHostelRequired(String hostelRequired) {
        this.hostelRequired = hostelRequired;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setPreferredLocation(String preferredLocation) {
        this.preferredLocation = preferredLocation;
    }
}