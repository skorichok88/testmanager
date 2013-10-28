package com.skoryk.testmanager.dao.question;

import com.skoryk.testmanager.domain.question.Question;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

import static com.google.common.base.Preconditions.checkNotNull;

@Transactional
public class QuestionDaoImpl
    implements QuestionDao
{
    @Autowired
    protected SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Question getRandomNotAnsweredQuestion(List<Integer> answeredQuestionIds) {
        checkNotNull(answeredQuestionIds);

        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Question.class)
                .setMaxResults(Question.MAX_RESULTS);

        if (!answeredQuestionIds.isEmpty())
            criteria.add(Restrictions.not(Restrictions.in("id", answeredQuestionIds)));

        List<Question> questions = (List<Question>) criteria.list();
        Question result = questions.get(new Random().nextInt(questions.size() - 1));
        Hibernate.initialize(result.getAnswers());

        return result;
    }
}
