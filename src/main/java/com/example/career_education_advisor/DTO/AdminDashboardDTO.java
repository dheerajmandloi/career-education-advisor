package com.example.career_education_advisor.DTO;

public class AdminDashboardDTO {

    private long totalStudents;
    private long totalCounselors;
    private long totalAdmins;

    public AdminDashboardDTO() {
    }

    public AdminDashboardDTO(
            long totalStudents,
            long totalCounselors,
            long totalAdmins) {

        this.totalStudents = totalStudents;
        this.totalCounselors = totalCounselors;
        this.totalAdmins = totalAdmins;
    }

    public long getTotalStudents() {
        return totalStudents;
    }

    public long getTotalCounselors() {
        return totalCounselors;
    }

    public long getTotalAdmins() {
        return totalAdmins;
    }

    public void setTotalStudents(long totalStudents) {
        this.totalStudents = totalStudents;
    }

    public void setTotalCounselors(long totalCounselors) {
        this.totalCounselors = totalCounselors;
    }

    public void setTotalAdmins(long totalAdmins) {
        this.totalAdmins = totalAdmins;
    }
}