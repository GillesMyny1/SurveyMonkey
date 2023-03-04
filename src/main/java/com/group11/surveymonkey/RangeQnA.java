package com.group11.surveymonkey;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class RangeQnA {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id = null;

    private String questionText;

    private Integer minimum;

    private Integer maximum;

    private Integer step;

    @ManyToOne
    private Survey survey;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "rangeQnA")
    private List<RangeAnswer> rangeAnswers;

    public RangeQnA() {
        rangeAnswers = new ArrayList<>();
    }

    public void addRangeAnswer(RangeAnswer answer) {
        if(answer != null) {
            rangeAnswers.add(answer);
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

    public Integer getMinimum() {
        return minimum;
    }

    public void setMinimum(Integer minimum) {
        this.minimum = minimum;
    }

    public Integer getMaximum() {
        return maximum;
    }

    public void setMaximum(Integer maximum) {
        this.maximum = maximum;
    }

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }

    public Survey getSurvey() {
        return this.survey;
    }

    public void setSurvey(Survey newSurvey) {
        this.survey = newSurvey;
    }

    public List<RangeAnswer> getRangeAnswers() {
        return this.rangeAnswers;
    }

    public void setRangeAnswers(List<RangeAnswer> newRangeAnswers) {
        this.rangeAnswers = newRangeAnswers;
    }
}