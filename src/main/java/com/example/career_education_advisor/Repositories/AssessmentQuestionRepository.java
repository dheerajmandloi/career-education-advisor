package com.example.career_education_advisor.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.career_education_advisor.Models.AssessmentQuestion;

@Repository
public interface AssessmentQuestionRepository
        extends JpaRepository<AssessmentQuestion, Long> {

    List<AssessmentQuestion> findByClassGroupAndActiveTrue(
            String classGroup);

    List<AssessmentQuestion> findByClassGroupAndStreamAndActiveTrue(
            String classGroup,
            String stream);
}