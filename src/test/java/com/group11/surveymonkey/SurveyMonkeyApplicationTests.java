package com.group11.surveymonkey;

import com.group11.surveymonkey.entity.*;
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

import static com.group11.surveymonkey.entity.User.UserType.ADMIN;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SurveyMonkeyApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
class SurveyMonkeyApplicationTests {
    @Value(value="${local.server.port}")
    int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void getSurveyJSON(){
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:"+port+"/createSurvey", String.class);
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    void getPlainSurvey(){
        Survey survey = restTemplate.getForObject("http://localhost:"+port+"/survey/1", Survey.class);
        Assertions.assertNotNull(survey.getSurveyName());
        Assertions.assertEquals(1,survey.getSurveyID());
    }
    @Test
    void addSurveyTest(){
        HttpEntity<Survey> request = new HttpEntity<>(new Survey("Test App Survey"));
        Survey survey = restTemplate.postForObject("http://localhost:"+port+"/survey",request, Survey.class);
        Assertions.assertNotNull(survey);
        Assertions.assertEquals("Test App Survey",survey.getSurveyName());
    }

    @Test
    void getTextQnATest(){
        TextQnA question = restTemplate.getForObject("http://localhost:"+port+"/textQnA/1", TextQnA.class);
        Assertions.assertNotNull(question.getQuestionText());
        Assertions.assertEquals(1,question.getId());
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
        ChoiceQnA question = restTemplate.getForObject("http://localhost:"+port+"/choiceQnA/1", ChoiceQnA.class);
        Assertions.assertNotNull(question.getQuestionText());
        Assertions.assertEquals(1,question.getId() );
    }
    @Test
    void addChoiceQnATest(){
        HttpEntity<ChoiceQnA> request = new HttpEntity<>(new ChoiceQnA("Question 2?"));
        ChoiceQnA question = restTemplate.postForObject("http://localhost:"+port+"/choiceQnA",request, ChoiceQnA.class);
        Assertions.assertNotNull(question);
        Assertions.assertEquals("Question 2?", question.getQuestionText());
    }
    @Test
    void getRangeQnATest(){
        RangeQnA question = restTemplate.getForObject("http://localhost:"+port+"/rangeQnA/1", RangeQnA.class);
        Assertions.assertNotNull(question.getQuestionText());
        Assertions.assertEquals(1,question.getId());
    }
    @Test
    void addRangeQnATest(){
        HttpEntity<RangeQnA> request = new HttpEntity<>(new RangeQnA("Question 3?"));
        RangeQnA question = restTemplate.postForObject("http://localhost:"+port+"/rangeQnA",request, RangeQnA.class);
        Assertions.assertNotNull(question);
        Assertions.assertEquals("Question 3?",question.getQuestionText());
    }
    @Test
    void getTextAnswer(){
        ChoiceAnswer answer = restTemplate.getForObject("http://localhost:"+port+"/textAnswer/1", ChoiceAnswer.class);
        Assertions.assertNotNull(answer.getAnswer());
        Assertions.assertEquals(1,answer.getId());
    }

    @Test
    void addTextAnswer(){
        HttpEntity<TextAnswer> request = new HttpEntity<>(new TextAnswer("Blue"));
        TextAnswer answer = restTemplate.postForObject("http://localhost:" + port+"/choiceAnswer", request, TextAnswer.class);
        Assertions.assertNotNull(answer);
        Assertions.assertEquals("Blue", answer.getAnswer());

    }
    @Test
    void getChoiceAnswer(){
        ChoiceAnswer answer = restTemplate.getForObject("http://localhost:"+port+"/choiceAnswer/1", ChoiceAnswer.class);
        Assertions.assertNotNull(answer.getAnswer());
        Assertions.assertEquals(1,answer.getId());
    }

    @Test
    void addChoiceAnswer(){
        HttpEntity<ChoiceAnswer> request = new HttpEntity<>(new ChoiceAnswer("Blue"));
        ChoiceAnswer answer = restTemplate.postForObject("http://localhost:" + port+"/choiceAnswer", request, ChoiceAnswer.class);
        Assertions.assertNotNull(answer);
        Assertions.assertEquals("Blue", answer.getAnswer());

    }

    @Test
    void getUser(){
        User user = restTemplate.getForObject("http://localhost:"+port+"/user/1", User.class);
        Assertions.assertNotNull(user.getUsername());
        Assertions.assertEquals(1,user.getId());
    }

    @Test
    void addUser(){
        HttpEntity<User> request = new HttpEntity<>(new User("admin","admin",ADMIN));
        User user = restTemplate.postForObject("http://localhost:" + port+"/user", request, User.class);
        Assertions.assertNotNull(user);
        Assertions.assertEquals("admin", user.getUsername());
    }
}