package com.skoryk.testmanager.web;

import com.skoryk.testmanager.domain.question.Question;
import com.skoryk.testmanager.domain.testresult.TestResult;
import com.skoryk.testmanager.service.question.QuestionService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

import static com.google.common.base.Preconditions.checkNotNull;

@Controller
@RequestMapping(TestingUrl.PREFIX)
public class TestingController
    extends BaseController
{
    @Autowired
    private QuestionService questionService;

    public void setQuestionService(QuestionService questionService) {
        this.questionService = questionService;
    }

    @RequestMapping(TestingUrl.REGISTRATION)
    public String registration(Model model)
    {
        model.addAttribute("testingUrl", TestingUrl.TESTING_URL);
        return getView(TestingUrl.REGISTRATION_VIEW);
    }

    @RequestMapping(TestingUrl.TESTING)
    public String startTesting(
            Model model,
            WebRequest request,
            HttpSession session
    ) throws Exception
    {
        Question question = questionService.getRandomNotAnsweredQuestion(new ArrayList<Integer>());

        TestResult testResult = new TestResult();
        testResult.setCurrentQuestion(question);
        testResult.setFirstName(request.getParameter("firstName"));
        testResult.setLastName(request.getParameter("lastName"));
        testResult.setAnsweredQuestionIds(new ArrayList<Integer>());
        testResult.setCorrectAnswersCount(0);
        session.setAttribute("testResult", testResult);

        model.addAttribute("answerUrl", TestingUrl.ANSWER_URL);
        model.addAttribute("resultsUrl", TestingUrl.RESULTS_URL);
        model.addAttribute("question", new JSONObject(question));

        return getView(TestingUrl.TESTING_VIEW);
    }

    @RequestMapping(value = TestingUrl.ANSWER, method = RequestMethod.POST)
    @ResponseBody
    public String answer(
            @RequestBody String chosenAnswerId,
            HttpSession session
    )
    {
        checkNotNull(chosenAnswerId);

        String result = "";
        TestResult testResult = (TestResult) session.getAttribute("testResult");
        if(testResult.getCurrentQuestion().getCorrectAnswer().getId().equals(new Integer(chosenAnswerId)))
            testResult.setCorrectAnswersCount(testResult.getCorrectAnswersCount() + 1);

        testResult.getAnsweredQuestionIds().add(testResult.getCurrentQuestion().getId());

        if(testResult.getAnsweredQuestionIds().size() < TestResult.MAX_QUESTIONS_QUANTITY)
        {
            Question newQuestion = questionService.getRandomNotAnsweredQuestion(testResult.getAnsweredQuestionIds());
            result = new JSONObject(newQuestion).toString();
            testResult.setCurrentQuestion(newQuestion);
        }

        session.setAttribute("testResult", testResult);

        return result;
    }

    @RequestMapping(TestingUrl.RESULTS)
    public String results(
            Model model,
            HttpSession session
    )
    {
        model.addAttribute("testResults", session.getAttribute("testResult"));
        return getView(TestingUrl.RESULTS_VIEW);
    }

}
