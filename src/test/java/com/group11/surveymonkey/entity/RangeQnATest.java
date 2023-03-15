package com.group11.surveymonkey.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.w3c.dom.ranges.Range;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RangeQnATest {
    RangeQnA rangeQnA;

    @BeforeEach
    void setUp() {
        rangeQnA = new RangeQnA("Does this work?");
        RangeAnswer rangeAnswerOne = new RangeAnswer();
        List<RangeAnswer> answerList = new ArrayList<>();
        rangeAnswerOne.setAnswer(7);
        answerList.add(rangeAnswerOne);
        rangeQnA.setMinimum(5);
        rangeQnA.setMaximum(10);
        rangeQnA.setStep(2);
        rangeQnA.setRangeAnswers(answerList);
    }

    @Test
    void getId() {
        Assertions.assertNull(rangeQnA.getId());
    }

    @Test
    void setId() {
        rangeQnA.setId(15);
        Assertions.assertEquals(15, rangeQnA.getId());
    }

    @Test
    void getQuestionText() {
        Assertions.assertNotNull(rangeQnA.getQuestionText());
        Assertions.assertEquals("Does this work?", rangeQnA.getQuestionText());
    }

    @Test
    void setQuestionText() {
        rangeQnA.setQuestionText("Test Text?");
        Assertions.assertEquals("Test Text?", rangeQnA.getQuestionText());
    }

    @Test
    void getMinimum() {
        Assertions.assertNotNull(rangeQnA.getMinimum());
        Assertions.assertEquals(5, rangeQnA.getMinimum());
    }

    @Test
    void setMinimum() {
        rangeQnA.setMinimum(7);
        Assertions.assertEquals(7, rangeQnA.getMinimum());
    }

    @Test
    void getMaximum() {
        Assertions.assertNotNull(rangeQnA.getMaximum());
        Assertions.assertEquals(10, rangeQnA.getMaximum());
    }

    @Test
    void setMaximum() {
        rangeQnA.setMaximum(17);
        Assertions.assertEquals(17, rangeQnA.getMaximum());
    }

    @Test
    void getStep() {
        Assertions.assertNotNull(rangeQnA.getStep());
        Assertions.assertEquals(2, rangeQnA.getStep());
    }

    @Test
    void setStep() {
        rangeQnA.setStep(4);
        Assertions.assertEquals(4, rangeQnA.getStep());
    }

    @Test
    void getRangeAnswers() {
        Assertions.assertNotNull(rangeQnA.getRangeAnswers());
        Assertions.assertEquals(7, rangeQnA.getRangeAnswers().get(0).getAnswer());
    }

    @Test
    void setRangeAnswers() {
        RangeAnswer rangeAnswerTest = new RangeAnswer();
        rangeAnswerTest.setAnswer(12);
        List<RangeAnswer> rangeAnswers = new ArrayList<>();
        rangeAnswers.add(rangeAnswerTest);
        rangeQnA.setRangeAnswers(rangeAnswers);
        Assertions.assertEquals(rangeAnswers, rangeQnA.getRangeAnswers());
    }

    @Test
    void addRangeAnswer() {
        RangeAnswer rangeAnswer = new RangeAnswer();
        rangeAnswer.setAnswer(30);
        rangeQnA.addRangeAnswer(rangeAnswer);
        Assertions.assertEquals(30, rangeQnA.getRangeAnswers().get(1).getAnswer());
    }
}