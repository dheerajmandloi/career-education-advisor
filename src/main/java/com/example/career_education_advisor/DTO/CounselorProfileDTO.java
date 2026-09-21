package com.example.career_education_advisor.DTO;

public class CounselorProfileDTO {

    private Long id;
    private Long userId;

    private String name;
    private String email;
    private String phone;

    private String highestQualification;
    private String universityInstitute;
    private String specialization;
    private Integer experienceYears;
    private String areasOfExpertise;
    private String professionalExperienceDetails;

    private String qualificationProof;
    private String resume;

    public CounselorProfileDTO() {
    }

    public CounselorProfileDTO(
            Long id,
            Long userId,
            String name,
            String email,
            String phone,
            String highestQualification,
            String universityInstitute,
            String specialization,
            Integer experienceYears,
            String areasOfExpertise,
            String professionalExperienceDetails,
            String qualificationProof,
            String resume) {

        this.id = id;
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.highestQualification = highestQualification;
        this.universityInstitute = universityInstitute;
        this.specialization = specialization;
        this.experienceYears = experienceYears;
        this.areasOfExpertise = areasOfExpertise;
        this.professionalExperienceDetails = professionalExperienceDetails;
        this.qualificationProof = qualificationProof;
        this.resume = resume;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
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

    public String getHighestQualification() {
        return highestQualification;
    }

    public String getUniversityInstitute() {
        return universityInstitute;
    }

    public String getSpecialization() {
        return specialization;
    }

    public Integer getExperienceYears() {
        return experienceYears;
    }

    public String getAreasOfExpertise() {
        return areasOfExpertise;
    }

    public String getProfessionalExperienceDetails() {
        return professionalExperienceDetails;
    }

    public String getQualificationProof() {
        return qualificationProof;
    }

    public String getResume() {
        return resume;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public void setHighestQualification(String highestQualification) {
        this.highestQualification = highestQualification;
    }

    public void setUniversityInstitute(String universityInstitute) {
        this.universityInstitute = universityInstitute;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void setExperienceYears(Integer experienceYears) {
        this.experienceYears = experienceYears;
    }

    public void setAreasOfExpertise(String areasOfExpertise) {
        this.areasOfExpertise = areasOfExpertise;
    }

    public void setProfessionalExperienceDetails(String professionalExperienceDetails) {
        this.professionalExperienceDetails = professionalExperienceDetails;
    }

    public void setQualificationProof(String qualificationProof) {
        this.qualificationProof = qualificationProof;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }
}