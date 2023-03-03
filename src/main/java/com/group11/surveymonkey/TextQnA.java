package com.group11.surveymonkey;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class TextQnA {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id = null;

    private String questionText;

    @ManyToOne
    private Survey survey;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "textQnA")
    private List<TextAnswer> textAnswers;

    public TextQnA() {
        textAnswers = new ArrayList<>();
    }

    public void addTextAnswer(TextAnswer answer) {
        if(answer != null) {
            textAnswers.add(answer);
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

    public Survey getSurvey() {
        return this.survey;
    }

    public void setSurvey(Survey newSurvey) {
        this.survey = newSurvey;
    }

    public List<TextAnswer> getTextAnswers() {
        return this.textAnswers;
    }

    public void setTextAnswers(List<TextAnswer> newTextAnswers) {
        this.textAnswers = newTextAnswers;
    }
}
