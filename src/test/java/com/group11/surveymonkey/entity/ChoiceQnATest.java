package com.group11.surveymonkey.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.w3c.dom.ranges.Range;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ChoiceQnATest {
    ChoiceQnA choiceQnA;

    @BeforeEach
    void setUp() {
        choiceQnA = new ChoiceQnA("What country are you from?");
        ChoiceAnswer choiceAnswerOne = new ChoiceAnswer();
        ChoiceAnswer choiceAnswerTwo = new ChoiceAnswer();
        ChoiceAnswer choiceAnswerThree = new ChoiceAnswer();
        ChoiceAnswer choiceAnswerFour = new ChoiceAnswer();
        List<ChoiceAnswer> answerList = new ArrayList<>();
        choiceAnswerOne.setAnswer("Canada");
        choiceAnswerTwo.setAnswer("USA");
        choiceAnswerThree.setAnswer("England");
        choiceAnswerFour.setAnswer("Brazil");
        answerList.add(choiceAnswerOne);
        answerList.add(choiceAnswerTwo);
        answerList.add(choiceAnswerThree);
        answerList.add(choiceAnswerFour);
        choiceQnA.setChoiceAnswers(answerList);
    }

    @Test
    void getId() {
        Assertions.assertNull(choiceQnA.getId());
    }

    @Test
    void setId() {
        choiceQnA.setId(2);
        Assertions.assertEquals(2, choiceQnA.getId());
    }

    @Test
    void getQuestionText() {
        Assertions.assertNotNull(choiceQnA.getQuestionText());
        Assertions.assertEquals("What country are you from?", choiceQnA.getQuestionText());
    }

    @Test
    void setQuestionText() {
        choiceQnA.setQuestionText("Test Text?");
        Assertions.assertEquals("Test Text?", choiceQnA.getQuestionText());
    }
    /*
    @Test
    void getChoices() {
        Assertions.assertNotNull(choiceQnA.getChoices());
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
    */

}