package com.example.career_education_advisor.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "counselor_profiles")
public class CounselorProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    // ================= PROFESSIONAL DETAILS =================

    @Column(nullable = false)
    private String highestQualification;

    @Column(nullable = false)
    private String universityInstitute;

    @Column(nullable = false)
    private String specialization;

    @Column(nullable = false)
    private Integer experienceYears;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String areasOfExpertise;

    @Column(columnDefinition = "TEXT")
    private String professionalExperienceDetails;

    // ================= VERIFICATION DOCUMENTS =================

    @Column(columnDefinition = "TEXT")
    private String qualificationProof;

    @Column(columnDefinition = "TEXT")
    private String resume;

    // ================= CONSTRUCTORS =================

    public CounselorProfile() {
    }

    // ================= GETTERS =================

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
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

    public void setUser(User user) {
        this.user = user;
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