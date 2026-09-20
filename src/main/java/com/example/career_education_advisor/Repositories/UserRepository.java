package com.example.career_education_advisor.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.career_education_advisor.Models.Role;
import com.example.career_education_advisor.Models.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

    boolean existsByPhone(String phone);

    long countByRole(Role role);

    List<User> findByRole(Role role);
}