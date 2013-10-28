package com.skoryk.testmanager.domain.question;

import com.skoryk.testmanager.domain.answer.Answer;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "questions")
public class Question
    implements Serializable
{
    public static final Integer MAX_RESULTS = 10;

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "text")
    private String text;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "question_answers",
            joinColumns = @JoinColumn(name = "question_id"),
            inverseJoinColumns = @JoinColumn(name = "answer_id")
    )
    private List<Answer> answers;

    @OneToOne()
    @JoinColumn(name = "correct_answer_id")
    private Answer correctAnswer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public Answer getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(Answer correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
