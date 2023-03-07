package com.group11.surveymonkey.entity;

import jakarta.persistence.*;

@Entity
public class TextAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id = null;

    private String answer;

    @ManyToOne
    public TextQnA textQnA;

    public TextAnswer() {
    }

    public TextAnswer(String submittedAnswer) {
        this.answer = submittedAnswer;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer newId) {
        this.id = newId;
    }

    public String getAnswer() {
        return this.answer;
    }

    public void setAnswer(String newAnswer) {
        this.answer = newAnswer;
    }

    public TextQnA getTextQnA() {
        return this.textQnA;
    }

    public void setTextQnA(TextQnA newTextQnA) {
        this.textQnA = newTextQnA;
    }
}
