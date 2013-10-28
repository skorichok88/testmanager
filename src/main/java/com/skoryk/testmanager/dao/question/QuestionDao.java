package com.skoryk.testmanager.dao.question;

import com.skoryk.testmanager.domain.question.Question;

import java.util.List;

public interface QuestionDao
{
    Question getRandomNotAnsweredQuestion(List<Integer> answeredQuestionIds);
}
