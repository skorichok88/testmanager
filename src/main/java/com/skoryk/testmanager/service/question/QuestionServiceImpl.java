package com.skoryk.testmanager.service.question;

import com.skoryk.testmanager.dao.question.QuestionDao;
import com.skoryk.testmanager.domain.question.Question;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

public class QuestionServiceImpl
    implements QuestionService
{
    @Autowired
    private QuestionDao questionDao;

    public void setQuestionDao(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    @Override
    public Question getRandomNotAnsweredQuestion(List<Integer> answeredQuestionIds) {
        checkNotNull(answeredQuestionIds);

        return questionDao.getRandomNotAnsweredQuestion(answeredQuestionIds);
    }
}
