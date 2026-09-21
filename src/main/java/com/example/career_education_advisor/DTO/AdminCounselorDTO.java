package com.example.career_education_advisor.DTO;

import com.example.career_education_advisor.Models.AccountStatus;

public class AdminCounselorDTO {

    // ================= USER DETAILS =================

    private Long id;
    private String name;
    private String email;
    private String phone;

    // ================= STATUS =================

    private AccountStatus status;

    // ================= PROFESSIONAL DETAILS =================

    private Long profileId;
    private String highestQualification;
    private String universityInstitute;
    private String specialization;
    private Integer experienceYears;
    private String areasOfExpertise;
    private String professionalExperienceDetails;

    // ================= VERIFICATION DOCUMENTS =================

    private String qualificationProof;
    private String resume;

    // ================= CONSTRUCTOR =================

    public AdminCounselorDTO() {
    }

    public AdminCounselorDTO(
            Long id,
            String name,
            String email,
            String phone,
            AccountStatus status,
            Long profileId,
            String highestQualification,
            String universityInstitute,
            String specialization,
            Integer experienceYears,
            String areasOfExpertise,
            String professionalExperienceDetails,
            String qualificationProof,
            String resume) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.status = status;
        this.profileId = profileId;
        this.highestQualification = highestQualification;
        this.universityInstitute = universityInstitute;
        this.specialization = specialization;
        this.experienceYears = experienceYears;
        this.areasOfExpertise = areasOfExpertise;
        this.professionalExperienceDetails = professionalExperienceDetails;
        this.qualificationProof = qualificationProof;
        this.resume = resume;
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

    public AccountStatus getStatus() {
        return status;
    }

    public Long getProfileId() {
        return profileId;
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

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    public void setHighestQualification(
            String highestQualification) {

        this.highestQualification = highestQualification;
    }

    public void setUniversityInstitute(
            String universityInstitute) {

        this.universityInstitute = universityInstitute;
    }

    public void setSpecialization(
            String specialization) {

        this.specialization = specialization;
    }

    public void setExperienceYears(
            Integer experienceYears) {

        this.experienceYears = experienceYears;
    }

    public void setAreasOfExpertise(
            String areasOfExpertise) {

        this.areasOfExpertise = areasOfExpertise;
    }

    public void setProfessionalExperienceDetails(
            String professionalExperienceDetails) {

        this.professionalExperienceDetails = professionalExperienceDetails;
    }

    public void setQualificationProof(
            String qualificationProof) {

        this.qualificationProof = qualificationProof;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }
}