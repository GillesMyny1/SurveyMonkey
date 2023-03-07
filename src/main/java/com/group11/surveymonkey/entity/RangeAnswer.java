package com.group11.surveymonkey.entity;

import jakarta.persistence.*;

@Entity
public class RangeAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id = null;

    private Integer answer;

    @ManyToOne
    public RangeQnA rangeQnA;

    public RangeAnswer() {
    }

    public RangeAnswer(Integer submittedAnswer) {
        this.answer = submittedAnswer;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer newId) {
        this.id = newId;
    }

    public Integer getAnswer() {
        return this.answer;
    }

    public void setAnswer(Integer newAnswer) {
        this.answer = newAnswer;
    }

    public RangeQnA getRangeQnA() {
        return this.rangeQnA;
    }

    public void setRangeQnA(RangeQnA newRangeQnA) {
        this.rangeQnA = newRangeQnA;
    }
}
