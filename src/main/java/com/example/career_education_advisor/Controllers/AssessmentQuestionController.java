package com.example.career_education_advisor.Controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    // =========================
    // STUDENT - GET QUESTIONS
    // =========================

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

    // =========================
    // ADMIN - GET ALL QUESTIONS
    // =========================

    @GetMapping("/admin/all")
    public ResponseEntity<List<AssessmentQuestion>> getAllQuestions() {

        return ResponseEntity.ok(
                questionRepository.findAll());
    }

    // =========================
    // ADMIN - GET QUESTION BY ID
    // =========================

    @GetMapping("/admin/{id}")
    public ResponseEntity<?> getQuestionById(
            @PathVariable Long id) {

        return questionRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // =========================
    // ADMIN - ADD QUESTION
    // =========================

    @PostMapping("/admin")
    public ResponseEntity<?> addQuestion(
            @RequestBody AssessmentQuestion question) {

        try {

            question.setActive(true);

            AssessmentQuestion savedQuestion = questionRepository.save(question);

            return ResponseEntity.ok(savedQuestion);

        } catch (Exception e) {

            return ResponseEntity.badRequest()
                    .body("Failed to add question: " + e.getMessage());
        }
    }

    // =========================
    // ADMIN - UPDATE QUESTION
    // =========================

    @PutMapping("/admin/{id}")
    public ResponseEntity<?> updateQuestion(
            @PathVariable Long id,
            @RequestBody AssessmentQuestion updatedQuestion) {

        try {

            AssessmentQuestion existingQuestion = questionRepository.findById(id)
                    .orElse(null);

            if (existingQuestion == null) {

                return ResponseEntity.notFound().build();
            }

            existingQuestion.setQuestionText(
                    updatedQuestion.getQuestionText());

            existingQuestion.setOptionA(
                    updatedQuestion.getOptionA());

            existingQuestion.setOptionB(
                    updatedQuestion.getOptionB());

            existingQuestion.setOptionC(
                    updatedQuestion.getOptionC());

            existingQuestion.setOptionD(
                    updatedQuestion.getOptionD());

            // Option Categories

            existingQuestion.setOptionACategory(
                    updatedQuestion.getOptionACategory());

            existingQuestion.setOptionBCategory(
                    updatedQuestion.getOptionBCategory());

            existingQuestion.setOptionCCategory(
                    updatedQuestion.getOptionCCategory());

            existingQuestion.setOptionDCategory(
                    updatedQuestion.getOptionDCategory());

            // Option Scores

            existingQuestion.setOptionAScore(
                    updatedQuestion.getOptionAScore());

            existingQuestion.setOptionBScore(
                    updatedQuestion.getOptionBScore());

            existingQuestion.setOptionCScore(
                    updatedQuestion.getOptionCScore());

            existingQuestion.setOptionDScore(
                    updatedQuestion.getOptionDScore());

            // Other details

            existingQuestion.setClassGroup(
                    updatedQuestion.getClassGroup());

            existingQuestion.setStream(
                    updatedQuestion.getStream());

            existingQuestion.setCategory(
                    updatedQuestion.getCategory());

            existingQuestion.setActive(
                    updatedQuestion.isActive());

            AssessmentQuestion savedQuestion = questionRepository.save(existingQuestion);

            return ResponseEntity.ok(savedQuestion);

        } catch (Exception e) {

            return ResponseEntity.badRequest()
                    .body("Failed to update question: " + e.getMessage());
        }
    }

    // =========================
    // ADMIN - DELETE QUESTION
    // =========================

    @DeleteMapping("/admin/{id}")
    public ResponseEntity<?> deleteQuestion(
            @PathVariable Long id) {

        try {

            AssessmentQuestion question = questionRepository.findById(id)
                    .orElse(null);

            if (question == null) {

                return ResponseEntity.notFound().build();
            }

            /*
             * Instead of permanently deleting the question,
             * we make it inactive.
             */

            question.setActive(false);

            questionRepository.save(question);

            return ResponseEntity.ok(
                    "Question deactivated successfully");

        } catch (Exception e) {

            return ResponseEntity.badRequest()
                    .body("Failed to deactivate question: "
                            + e.getMessage());
        }
    }
}