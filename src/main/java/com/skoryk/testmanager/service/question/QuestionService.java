package com.skoryk.testmanager.service.question;

import com.skoryk.testmanager.domain.question.Question;

import java.util.List;

public interface QuestionService
{
    Question getRandomNotAnsweredQuestion(List<Integer> answeredQuestionIds);
}
