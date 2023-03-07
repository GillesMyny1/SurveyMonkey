package com.group11.surveymonkey;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class ChoiceQnA {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id = null;

    private String questionText;

    private static List<String> choices;

    @ManyToOne
    private Survey survey;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "choiceQnA")
    private List<ChoiceAnswer> choiceAnswers;

    public ChoiceQnA() {
        this.choiceAnswers = new ArrayList<>();
        this.choices = new ArrayList<>();
    }

    public ChoiceQnA(String question) {
        this.choiceAnswers = new ArrayList<>();
        this.choices = new ArrayList<>();
        this.questionText = question;
    }

    public void addChoiceAnswer(ChoiceAnswer answer) {
        if(answer != null) {
            choiceAnswers.add(answer);
        }
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer newId) {
        this.id = newId;
    }

    public String getQuestionText() {
        return this.questionText;
    }

    public void setQuestionText(String newQuestionText) {
        this.questionText = newQuestionText;
    }

    public List<String> getChoices() {
        return choices;
    }

    public void setChoices(List<String> choices) {
        this.choices = choices;
    }

    public Survey getSurvey() {
        return this.survey;
    }

    public void setSurvey(Survey newSurvey) {
        this.survey = newSurvey;
    }

    public List<ChoiceAnswer> getChoiceAnswers() {
        return this.choiceAnswers;
    }

    public void setChoiceAnswers(List<ChoiceAnswer> newChoiceAnswers) {
        this.choiceAnswers = newChoiceAnswers;
    }
}
