package com.example.career_education_advisor.DTO;

public class AdminStudentDTO {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private String role;

    public AdminStudentDTO() {
    }

    public AdminStudentDTO(
            Long id,
            String name,
            String email,
            String phone,
            String role) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.role = role;
    }

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
}