package com.group11.surveymonkey.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RangeAnswerTest {
    RangeAnswer rangeAnswer;

    @BeforeEach
    void setUp() {
        rangeAnswer = new RangeAnswer();
    }

    @Test
    void getId() {
        Assertions.assertNull(rangeAnswer.getId());
    }

    @Test
    void setId() {
        rangeAnswer.setId(15);
        Assertions.assertEquals(15, rangeAnswer.getId());
    }

    @Test
    void getAnswer() {
        Assertions.assertNull(rangeAnswer.getAnswer());
    }

    @Test
    void setAnswer() {
        rangeAnswer.setAnswer(20);
        Assertions.assertEquals(20, rangeAnswer.getAnswer());
    }

    @Test
    void getRangeQnA() {
        Assertions.assertNull(rangeAnswer.getRangeQnA());
    }

    @Test
    void setRangeQnA() {
        RangeQnA rangeQnA = new RangeQnA();
        rangeAnswer.setRangeQnA(rangeQnA);
        Assertions.assertEquals(rangeQnA, rangeAnswer.getRangeQnA());
    }
}