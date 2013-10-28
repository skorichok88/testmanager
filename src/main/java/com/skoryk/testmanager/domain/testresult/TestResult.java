package com.skoryk.testmanager.domain.testresult;

import com.skoryk.testmanager.domain.question.Question;

import java.util.List;

public class TestResult
{
    public static final Integer MAX_QUESTIONS_QUANTITY = 5;

    private String firstName;
    private String lastName;
    private Question currentQuestion;
    private List<Integer> answeredQuestionIds;
    private Integer correctAnswersCount;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Question getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(Question currentQuestion) {
        this.currentQuestion = currentQuestion;
    }

    public List<Integer> getAnsweredQuestionIds() {
        return answeredQuestionIds;
    }

    public void setAnsweredQuestionIds(List<Integer> answeredQuestionIds) {
        this.answeredQuestionIds = answeredQuestionIds;
    }

    public Integer getCorrectAnswersCount() {
        return correctAnswersCount;
    }

    public void setCorrectAnswersCount(Integer correctAnswersCount) {
        this.correctAnswersCount = correctAnswersCount;
    }
}
