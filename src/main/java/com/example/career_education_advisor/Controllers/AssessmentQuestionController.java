package com.example.career_education_advisor.Controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.career_education_advisor.Models.AssessmentQuestion;
import com.example.career_education_advisor.Repositories.AssessmentQuestionRepository;

@RestController
@RequestMapping("/api/assessment/questions")
@CrossOrigin(origins = "*")
public class AssessmentQuestionController {

    private final AssessmentQuestionRepository questionRepository;

    public AssessmentQuestionController(
            AssessmentQuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @GetMapping
    public ResponseEntity<List<AssessmentQuestion>> getQuestions(
            @RequestParam String classGroup,
            @RequestParam(required = false) String stream) {

        List<AssessmentQuestion> questions = questionRepository.findByClassGroupAndActiveTrue(classGroup);

        if (stream != null && !stream.isBlank()) {
            questions = questions.stream()
                    .filter(question -> "ALL".equalsIgnoreCase(question.getStream())
                            || stream.equalsIgnoreCase(question.getStream()))
                    .collect(Collectors.toList());
        }

        return ResponseEntity.ok(questions);
    }
}