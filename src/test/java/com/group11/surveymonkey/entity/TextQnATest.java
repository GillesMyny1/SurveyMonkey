package com.group11.surveymonkey.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TextQnATest {

    TextQnA textQnA;

    @BeforeEach
    void setUp() {
        textQnA = new TextQnA("Who am I?");
        TextAnswer textAnswer1 = new TextAnswer();
        List<TextAnswer> answerList = new ArrayList<>();
        textAnswer1.setAnswer("I am text!");
        answerList.add(textAnswer1);
        textQnA.setTextAnswers(answerList);
    }

    @Test
    void addTextAnswer() {
        Assertions.assertEquals("I am text!", textQnA.getTextAnswers().get(0).getAnswer());
        TextAnswer textAnswer2 = new TextAnswer();
        textAnswer2.setAnswer("I am text too!");
        textQnA.addTextAnswer(textAnswer2);
        Assertions.assertEquals("I am text too!", textQnA.getTextAnswers().get(1).getAnswer());
    }

    @Test
    void getId() {
        Assertions.assertNull(textQnA.getId());
    }

    @Test
    void setId() {
        textQnA.setId(4);
        Assertions.assertEquals(4, textQnA.getId());
    }

    @Test
    void getQuestionText() {
        Assertions.assertNotNull(textQnA.getQuestionText());
        Assertions.assertEquals("Who am I?", textQnA.getQuestionText());
    }

    @Test
    void setQuestionText() {
        textQnA.setQuestionText("Where am I?");
        Assertions.assertNotNull(textQnA.getQuestionText());
        Assertions.assertEquals("Where am I?", textQnA.getQuestionText());
    }

    @Test
    void getTextAnswers() {
        Assertions.assertNotNull(textQnA.getTextAnswers());
        Assertions.assertEquals("I am text!", textQnA.getTextAnswers().get(0).getAnswer());
    }

    @Test
    void setTextAnswers() {
        TextAnswer textAnswer3 = new TextAnswer();
        textAnswer3.setAnswer("Text three!");
        List<TextAnswer> textAnswers = new ArrayList<>();
        textAnswers.add(textAnswer3);
        textQnA.setTextAnswers(textAnswers);
        Assertions.assertEquals(textAnswers, textQnA.getTextAnswers());
    }
}