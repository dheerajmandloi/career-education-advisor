package com.example.career_education_advisor.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "assessment_questions")
public class AssessmentQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 1000)
    private String questionText;

    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;

    // Score category for each option
    private String optionACategory;
    private String optionBCategory;
    private String optionCCategory;
    private String optionDCategory;

    // Score for each option
    private int optionAScore;
    private int optionBScore;
    private int optionCScore;
    private int optionDScore;

    private String classGroup; // 9_10 or 11_12
    private String stream; // ALL, PCB, PCM, Commerce, Arts
    private String category;
    private boolean active = true;

    public Long getId() {
        return id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public String getOptionACategory() {
        return optionACategory;
    }

    public void setOptionACategory(String optionACategory) {
        this.optionACategory = optionACategory;
    }

    public String getOptionBCategory() {
        return optionBCategory;
    }

    public void setOptionBCategory(String optionBCategory) {
        this.optionBCategory = optionBCategory;
    }

    public String getOptionCCategory() {
        return optionCCategory;
    }

    public void setOptionCCategory(String optionCCategory) {
        this.optionCCategory = optionCCategory;
    }

    public String getOptionDCategory() {
        return optionDCategory;
    }

    public void setOptionDCategory(String optionDCategory) {
        this.optionDCategory = optionDCategory;
    }

    public int getOptionAScore() {
        return optionAScore;
    }

    public void setOptionAScore(int optionAScore) {
        this.optionAScore = optionAScore;
    }

    public int getOptionBScore() {
        return optionBScore;
    }

    public void setOptionBScore(int optionBScore) {
        this.optionBScore = optionBScore;
    }

    public int getOptionCScore() {
        return optionCScore;
    }

    public void setOptionCScore(int optionCScore) {
        this.optionCScore = optionCScore;
    }

    public int getOptionDScore() {
        return optionDScore;
    }

    public void setOptionDScore(int optionDScore) {
        this.optionDScore = optionDScore;
    }

    public String getClassGroup() {
        return classGroup;
    }

    public void setClassGroup(String classGroup) {
        this.classGroup = classGroup;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}