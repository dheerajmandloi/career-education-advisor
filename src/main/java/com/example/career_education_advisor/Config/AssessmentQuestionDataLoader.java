package com.example.career_education_advisor.Config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.career_education_advisor.Models.AssessmentQuestion;
import com.example.career_education_advisor.Repositories.AssessmentQuestionRepository;

@Component
public class AssessmentQuestionDataLoader implements CommandLineRunner {

    private final AssessmentQuestionRepository questionRepository;

    public AssessmentQuestionDataLoader(
            AssessmentQuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public void run(String... args) {

        if (questionRepository.count() > 0) {
            return;
        }

        addQuestion(
                "Which activity do you enjoy most?",
                "Solving logical problems",
                "Helping people",
                "Creating designs",
                "Managing money",
                "9_10",
                "ALL",
                "interest");

        addQuestion(
                "Which type of work do you prefer?",
                "Working with computers",
                "Working with people",
                "Research and experiments",
                "Business and planning",
                "9_10",
                "ALL",
                "work_style");

        addQuestion(
                "Which activity interests you most?",
                "Laboratory work",
                "Patient care",
                "Biology research",
                "Healthcare management",
                "11_12",
                "PCB",
                "healthcare");

        addQuestion(
                "Which activity interests you most?",
                "Building machines",
                "Programming",
                "Solving mathematics",
                "Designing technology",
                "11_12",
                "PCM",
                "technology");

        addQuestion(
                "Which activity interests you most?",
                "Accounting",
                "Business planning",
                "Investment",
                "Marketing",
                "11_12",
                "Commerce",
                "business");

        addQuestion(
                "Which activity interests you most?",
                "Writing",
                "Law and society",
                "Psychology",
                "Art and design",
                "11_12",
                "Arts",
                "social_creative");
    }

    private void addQuestion(
            String questionText,
            String optionA,
            String optionB,
            String optionC,
            String optionD,
            String classGroup,
            String stream,
            String category) {

        AssessmentQuestion question = new AssessmentQuestion();

        question.setQuestionText(questionText);
        question.setOptionA(optionA);
        question.setOptionB(optionB);
        question.setOptionC(optionC);
        question.setOptionD(optionD);
        question.setClassGroup(classGroup);
        question.setStream(stream);
        question.setCategory(category);
        question.setActive(true);

        questionRepository.save(question);
    }
}