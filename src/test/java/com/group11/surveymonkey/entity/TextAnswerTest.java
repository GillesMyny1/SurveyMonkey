package com.group11.surveymonkey.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextAnswerTest {

    TextAnswer textAnswer;
    TextQnA textQnA;

    @BeforeEach
    void setUp() {
        textAnswer = new TextAnswer();
        textAnswer.setAnswer("I am text!");
        textQnA = new TextQnA();
        textQnA.setQuestionText("Who am I?");
        textAnswer.setTextQnA(textQnA);
    }

    @Test
    void getId() {
        Assertions.assertNull(textAnswer.getId());
    }

    @Test
    void setId() {
        textAnswer.setId(2);
        Assertions.assertEquals(2, textAnswer.getId());
    }

    @Test
    void getAnswer() {
        Assertions.assertEquals("I am text!", textAnswer.getAnswer());
    }

    @Test
    void setAnswer() {
        textAnswer.setAnswer("Texting!");
        Assertions.assertEquals("Texting!", textAnswer.getAnswer());
    }

    @Test
    void getTextQnA() {
        Assertions.assertEquals("Who am I?", textAnswer.getTextQnA().getQuestionText());
    }

    @Test
    void setTextQnA() {
        TextQnA textQnA1 = new TextQnA();
        textQnA1.setQuestionText("Where am I?");
        textAnswer.setTextQnA(textQnA1);
        Assertions.assertEquals("Where am I?", textAnswer.getTextQnA().getQuestionText());
    }
}