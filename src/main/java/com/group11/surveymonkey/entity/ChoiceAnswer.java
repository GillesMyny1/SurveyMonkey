package com.group11.surveymonkey.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class ChoiceAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id = null;

    private String answer;

    @JsonIgnore
    @ManyToOne
    public ChoiceQnA choiceQnA;

    public ChoiceAnswer() {
    }

    public ChoiceAnswer(String submittedAnswer) {
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

    public ChoiceQnA getChoiceQnA() {
        return this.choiceQnA;
    }

    public void setChoiceQnA(ChoiceQnA newChoiceQnA) {
        this.choiceQnA = newChoiceQnA;
    }
}
