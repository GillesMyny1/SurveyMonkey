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
        String choiceOne = "Canada";
        String choiceTwo = "USA";
        String choiceThree = "England";
        String choiceFour = "Brazil";
        List<String> choices = new ArrayList<>();
        choices.add(choiceOne);
        choices.add(choiceTwo);
        choices.add(choiceThree);
        choices.add(choiceFour);
        choiceQnA.setChoices(choices);
        List<ChoiceAnswer> answerList = new ArrayList<>();
        ChoiceAnswer choiceAnswer = new ChoiceAnswer();
        choiceAnswer.setAnswer(choiceOne);
        answerList.add(choiceAnswer);
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

    @Test
    void getChoices() {
        Assertions.assertNotNull(choiceQnA.getChoices());
    }

    @Test
    void setChoices() {
        String choiceAnswerOne = "New Country";
        List<String> choices = new ArrayList<>();
        choices.add(choiceAnswerOne);
        choiceQnA.setChoices(choices);
        Assertions.assertEquals(choiceQnA.getChoices(), choices);
    }


    @Test
    void getChoiceAnswers() {
        Assertions.assertNotNull(choiceQnA.getChoiceAnswers());
        Assertions.assertEquals("Canada", choiceQnA.getChoiceAnswers().get(0).getAnswer());
    }

    @Test
    void setChoiceAnswers() {
        ChoiceAnswer choiceAnswerTest = new ChoiceAnswer();
        choiceAnswerTest.setAnswer("USA");
        List<ChoiceAnswer> choiceAnswers = new ArrayList<>();
        choiceAnswers.add(choiceAnswerTest);
        choiceQnA.setChoiceAnswers(choiceAnswers);
        Assertions.assertEquals(choiceAnswers, choiceQnA.getChoiceAnswers());
    }

    @Test
    void addChoiceAnswer() {
        ChoiceAnswer choiceAnswer = new ChoiceAnswer();
        choiceAnswer.setAnswer("Brazil");
        choiceQnA.addChoiceAnswer(choiceAnswer);
        Assertions.assertEquals("Brazil", choiceQnA.getChoiceAnswers().get(1).getAnswer());
    }


}