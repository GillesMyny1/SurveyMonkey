package com.group11.surveymonkey;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.junit.Assert.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SurveyMonkeyApplicationTests {

    @Value(value="${local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void getSurveyJSON(){
        ResponseEntity<String> response = this.restTemplate.getForEntity("http://localhost:"+port+"/survey", String.class);
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
    }
    @Test
    void getPlainSurvey(){
        Survey survey = restTemplate.getForObject("http://localhost:"+port+"/createSurvey", Survey.class);
        Assertions.assertNotNull(survey.getName());
        Assertions.assertEquals(survey.getSurveyID(), null);
    }
    @Test
    void addSurveyTest(){
        HttpEntity<Survey> request = new HttpEntity<>(new Survey("First Survey"));
        Survey survey = restTemplate.postForObject("http://localhost:"+port+"/createSurvey",request, Survey.class);
        Assertions.assertNotNull(survey);
        Assertions.assertEquals(survey.getSurveyName(),"First Survey");
    }
    @Test
    void getTextQnATest(){
        TextQnA question = restTemplate.getForObject("http://localhost:"+port+"/createTextQnA", TextQnA.class);
        Assertions.assertNotNull(question.getQuestionText());
        Assertions.assertEquals(question.getId(), null);
    }
    @Test
    void addTextQnATest(){
        HttpEntity<TextQnA> request = new HttpEntity<>(new Survey("Question 1?"));
        TextQnA question = restTemplate.postForObject("http://localhost:"+port+"/createTextQnA",request, TextQnA.class);
        Assertions.assertNotNull(question);
        Assertions.assertEquals(question.getQuestionText(),"Question 1?");
    }
    @Test
    void getChoiceQnATest(){
        ChoiceQnA question = restTemplate.getForObject("http://localhost:"+port+"/createChoiceQnA", ChoiceQnA.class);
        Assertions.assertNotNull(question.getQuestionText());
        Assertions.assertEquals(question.getId(), null);
    }
    @Test
    void addTextQnATest(){
        HttpEntity<ChoiceQnA> request = new HttpEntity<>(new Survey("Question 2?"));
        ChoiceQnA question = restTemplate.postForObject("http://localhost:"+port+"/createChoiceQnA",request, ChoiceQnA.class);
        Assertions.assertNotNull(question);
        Assertions.assertEquals(question.getQuestionText(),"Question 2?");
    }
    @Test
    void getRangeQnATest(){
        RangeQnA question = restTemplate.getForObject("http://localhost:"+port+"/createRangeQnA", RangeQnA.class);
        Assertions.assertNotNull(question.getQuestionText());
        Assertions.assertEquals(question.getId(), null);
    }
    @Test
    void addRangeQnATest(){
        HttpEntity<RangeQnA> request = new HttpEntity<>(new Survey("Question 3?"));
        RangeQnA question = restTemplate.postForObject("http://localhost:"+port+"/createRangeQnA",request, RangeQnA.class);
        Assertions.assertNotNull(question);
        Assertions.assertEquals(question.getQuestionText(),"Question 3?");
    }

}
