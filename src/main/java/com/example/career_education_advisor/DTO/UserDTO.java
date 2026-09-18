package com.example.career_education_advisor.DTO;

import com.example.career_education_advisor.Models.Role;

public class UserDTO {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private Role role;

    // Default Constructor
    public UserDTO() {
    }

    // Parameterized Constructor
    public UserDTO(Long id, String name, String email,
            String phone, Role role) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.role = role;
    }

    // Getters
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

    public Role getRole() {
        return role;
    }

    // Setters
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

    public void setRole(Role role) {
        this.role = role;
    }
}