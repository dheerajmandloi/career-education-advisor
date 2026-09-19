package com.example.career_education_advisor.DTO;

public class LoginDTO {

    private String email;
    private String password;

    // Default Constructor
    public LoginDTO() {
    }

    // Parameterized Constructor
    public LoginDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Getters
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    // Setters
    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}