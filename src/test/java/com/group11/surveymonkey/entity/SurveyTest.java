package com.group11.surveymonkey.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SurveyTest {

    Survey survey;

    @BeforeEach
    void setUp() {
        survey = new Survey();
    }

    @Test
    void addTextQnA() {
        TextQnA textQnA = new TextQnA();
        List<TextQnA> textQnAList = new ArrayList<>();
        survey.setTextList(textQnAList);
        survey.addTextQnA(textQnA);
        Assertions.assertEquals(textQnA, survey.getTextList().get(0));
    }

    @Test
    void addChoiceQnA() {
        ChoiceQnA choiceQnA = new ChoiceQnA();
        List<ChoiceQnA> choiceQnAList = new ArrayList<>();
        survey.setChoiceList(choiceQnAList);
        survey.addChoiceQnA(choiceQnA);
        Assertions.assertEquals(choiceQnA, survey.getChoiceList().get(0));
    }

    @Test
    void addRangeQnA() {
        RangeQnA rangeQnA = new RangeQnA();
        List<RangeQnA> rangeQnAList = new ArrayList<>();
        survey.setRangeList(rangeQnAList);
        survey.addRangeQnA(rangeQnA);
        Assertions.assertEquals(rangeQnA, survey.getRangeList().get(0));
    }

    @Test
    void getActiveStatus() {
        Assertions.assertEquals(true, survey.getActiveStatus());
    }

    @Test
    void setActiveStatus() {
        survey.setActiveStatus(false);
        Assertions.assertEquals(false, survey.getActiveStatus());
    }

    @Test
    void getTextList() {
        Assertions.assertEquals(0, survey.getTextList().size());
    }

    @Test
    void setTextList() {
        TextQnA textQnA = new TextQnA();
        List<TextQnA> textQnAList = new ArrayList<>();
        textQnAList.add(textQnA);
        survey.setTextList(textQnAList);
        Assertions.assertEquals(textQnAList, survey.getTextList());
    }

    @Test
    void getRangeList() {
        Assertions.assertEquals(0, survey.getRangeList().size());
    }

    @Test
    void setRangeList() {
        RangeQnA rangeQnA = new RangeQnA();
        List<RangeQnA> rangeQnAList = new ArrayList<>();
        rangeQnAList.add(rangeQnA);
        survey.setRangeList(rangeQnAList);
        Assertions.assertEquals(rangeQnAList, survey.getRangeList());
    }

    @Test
    void getChoiceList() {
        Assertions.assertEquals(0, survey.getChoiceList().size());
    }

    @Test
    void setChoiceList() {
        ChoiceQnA choiceQnA = new ChoiceQnA();
        List<ChoiceQnA> choiceQnAList = new ArrayList<>();
        choiceQnAList.add(choiceQnA);
        survey.setChoiceList(choiceQnAList);
        Assertions.assertEquals(choiceQnAList, survey.getChoiceList());
    }

    @Test
    void getSurveyID() {
        Assertions.assertNull(survey.getSurveyID());
    }

    @Test
    void setSurveyID() {
        survey.setSurveyID(5);
        Assertions.assertEquals(5, survey.getSurveyID());
    }

    @Test
    void getSurveyName() {
        Assertions.assertNull(survey.getSurveyName());
    }

    @Test
    void setSurveyName() {
        survey.setSurveyName("Testing Survey");
        Assertions.assertEquals("Testing Survey", survey.getSurveyName());
    }
}