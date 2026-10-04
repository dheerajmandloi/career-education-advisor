package com.example.career_education_advisor.Services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.career_education_advisor.Models.AssessmentQuestion;
import com.example.career_education_advisor.Models.AssessmentSubmission;
import com.example.career_education_advisor.Repositories.AssessmentQuestionRepository;

@Service
public class AssessmentService {

    private final AssessmentQuestionRepository questionRepository;

    public AssessmentService(
            AssessmentQuestionRepository questionRepository) {

        this.questionRepository = questionRepository;
    }

    public Map<String, Object> processAssessment(
            AssessmentSubmission submission) {

        Map<String, Integer> scores = new HashMap<>();

        // No answers submitted
        if (submission.getAnswers() == null ||
                submission.getAnswers().isEmpty()) {

            return createEmptyResult(submission);
        }

        /*
         * answers format:
         *
         * {
         * "1": "A",
         * "2": "C",
         * "3": "B"
         * }
         *
         * Key = Question ID
         * Value = Selected option
         */

        for (Map.Entry<String, String> answerEntry : submission.getAnswers().entrySet()) {

            try {

                Long questionId = Long.parseLong(answerEntry.getKey());

                String selectedOption = answerEntry.getValue();

                if (selectedOption == null ||
                        selectedOption.isBlank()) {

                    continue;
                }

                // Find question from database

                AssessmentQuestion question = questionRepository
                        .findById(questionId)
                        .orElse(null);

                if (question == null) {
                    continue;
                }

                String category = null;
                int score = 0;

                // Determine selected option

                switch (selectedOption.toUpperCase()) {

                    case "A":

                        category = question.getOptionACategory();

                        score = question.getOptionAScore();

                        break;

                    case "B":

                        category = question.getOptionBCategory();

                        score = question.getOptionBScore();

                        break;

                    case "C":

                        category = question.getOptionCCategory();

                        score = question.getOptionCScore();

                        break;

                    case "D":

                        category = question.getOptionDCategory();

                        score = question.getOptionDScore();

                        break;

                    default:

                        continue;
                }

                // Ignore invalid category

                if (category == null ||
                        category.isBlank()) {

                    continue;
                }

                /*
                 * Add score to category
                 *
                 * Example:
                 *
                 * Technology = 5
                 * Analytical = 3
                 * Creative = 1
                 */

                scores.put(
                        category,
                        scores.getOrDefault(category, 0)
                                + score);

            } catch (NumberFormatException e) {

                // Ignore invalid question ID

            }

        }

        // Find highest scoring category

        String topCategory = scores.entrySet()
                .stream()
                .max(
                        Map.Entry.comparingByValue())
                .map(
                        Map.Entry::getKey)
                .orElse("general");

        // Find highest score

        int topScore = scores.getOrDefault(
                topCategory,
                0);

        // Create result

        Map<String, Object> result = new HashMap<>();

        result.put(
                "classGroup",
                submission.getClassGroup());

        result.put(
                "stream",
                submission.getStream());

        result.put(
                "scores",
                scores);

        result.put(
                "topCategory",
                topCategory);

        result.put(
                "topScore",
                topScore);

        result.put(
                "message",
                "Assessment submitted successfully");

        return result;
    }

    // ==============================
    // EMPTY RESULT
    // ==============================

    private Map<String, Object> createEmptyResult(
            AssessmentSubmission submission) {

        Map<String, Object> result = new HashMap<>();

        result.put(
                "classGroup",
                submission.getClassGroup());

        result.put(
                "stream",
                submission.getStream());

        result.put(
                "scores",
                new HashMap<String, Integer>());

        result.put(
                "topCategory",
                "general");

        result.put(
                "topScore",
                0);

        result.put(
                "message",
                "No answers submitted");

        return result;
    }
}