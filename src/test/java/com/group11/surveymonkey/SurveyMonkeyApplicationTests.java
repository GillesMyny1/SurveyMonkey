package com.group11.surveymonkey;

import com.group11.surveymonkey.entity.ChoiceQnA;
import com.group11.surveymonkey.entity.RangeQnA;
import com.group11.surveymonkey.entity.Survey;
import com.group11.surveymonkey.entity.TextQnA;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SurveyMonkeyApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
class SurveyMonkeyApplicationTests {
    @Value(value="${local.server.port}")
    int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void getSurveyJSON(){
        ResponseEntity<String> response = this.restTemplate.getForEntity("http://localhost:"+port+"/survey", String.class);
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
    }
    @Test
    void getPlainSurvey(){
        Survey survey = restTemplate.getForObject("http://localhost:"+port+"/survey", Survey.class);
        Assertions.assertNotNull(survey.getSurveyName());
        Assertions.assertEquals(survey.getSurveyID(), null);
    }
    @Test
    void addSurveyTest(){
        HttpEntity<Survey> request = new HttpEntity<>(new Survey("First Survey"));
        Survey survey = restTemplate.postForObject("http://localhost:"+port+"/survey",request, Survey.class);
        Assertions.assertNotNull(survey);
        Assertions.assertEquals(survey.getSurveyName(),"First Survey");
    }
    @Test
    void getTextQnATest(){
        TextQnA question = restTemplate.getForObject("http://localhost:"+port+"/textQnA", TextQnA.class);
        Assertions.assertNotNull(question.getQuestionText());
        Assertions.assertEquals(question.getId(), null);
    }
    @Test
    void addTextQnATest(){
        HttpEntity<TextQnA> request = new HttpEntity<TextQnA>(new TextQnA("Question 1?"));
        TextQnA question = restTemplate.postForObject("http://localhost:"+port+"/textQnA",request, TextQnA.class);
        Assertions.assertNotNull(question);
        Assertions.assertEquals("Question 1?",question.getQuestionText());
    }
    @Test
    void getChoiceQnATest(){
        ChoiceQnA question = restTemplate.getForObject("http://localhost:"+port+"/choiceQnA", ChoiceQnA.class);
        Assertions.assertNotNull(question.getQuestionText());
        Assertions.assertEquals(question.getId(), null);
    }
    @Test
    void addChoiceQnATest(){
        HttpEntity<ChoiceQnA> request = new HttpEntity<>(new ChoiceQnA("Question 2?"));
        ChoiceQnA question = restTemplate.postForObject("http://localhost:"+port+"/choiceQnA",request, ChoiceQnA.class);
        Assertions.assertNotNull(question);
        Assertions.assertEquals(question.getQuestionText(),"Question 2?");
    }
    @Test
    void getRangeQnATest(){
        RangeQnA question = restTemplate.getForObject("http://localhost:"+port+"/rangeQnA", RangeQnA.class);
        Assertions.assertNotNull(question.getQuestionText());
        Assertions.assertEquals(question.getId(), null);
    }
    @Test
    void addRangeQnATest(){
        HttpEntity<RangeQnA> request = new HttpEntity<>(new RangeQnA("Question 3?"));
        RangeQnA question = restTemplate.postForObject("http://localhost:"+port+"/rangeQnA",request, RangeQnA.class);
        Assertions.assertNotNull(question);
        Assertions.assertEquals(question.getQuestionText(),"Question 3?");
    }

}
