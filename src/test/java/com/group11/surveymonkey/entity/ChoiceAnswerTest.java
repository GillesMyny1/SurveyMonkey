package com.group11.surveymonkey.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChoiceAnswerTest {
    ChoiceAnswer choiceAnswer;

    @BeforeEach
    void setUp() {
        choiceAnswer = new ChoiceAnswer();
    }

    @Test
    void getId() {
        Assertions.assertNull(choiceAnswer.getId());
    }

    @Test
    void setId() {
        choiceAnswer.setId(5);
        Assertions.assertEquals(5, choiceAnswer.getId());
    }

    @Test
    void getAnswer() {
        Assertions.assertNull(choiceAnswer.getAnswer());
    }

    @Test
    void setAnswer() {
        choiceAnswer.setAnswer("Canada");
        Assertions.assertEquals("Canada", choiceAnswer.getAnswer());
    }

    @Test
    void getChoiceQnA() {
        Assertions.assertNull(choiceAnswer.getChoiceQnA());
    }

    @Test
    void setChoiceQnA() {
        ChoiceQnA ChoiceQnA = new ChoiceQnA();
        choiceAnswer.setChoiceQnA(ChoiceQnA);
        Assertions.assertEquals(ChoiceQnA, choiceAnswer.getChoiceQnA());
    }
}