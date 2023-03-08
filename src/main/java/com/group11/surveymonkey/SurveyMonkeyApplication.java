package com.group11.surveymonkey;

import com.group11.surveymonkey.entity.ChoiceQnA;
import com.group11.surveymonkey.entity.RangeQnA;
import com.group11.surveymonkey.entity.Survey;
import com.group11.surveymonkey.entity.TextQnA;
import com.group11.surveymonkey.repository.SurveyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SurveyMonkeyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SurveyMonkeyApplication.class, args);
    }

    public static final Logger log = LoggerFactory.getLogger(SurveyMonkeyApplication.class);

    @Bean
    public CommandLineRunner demo(SurveyRepository repositorySurvey) {
        return (args) -> {
            Survey s = new Survey("Test Survey");
            s.addTextQnA(new TextQnA("Is this a text question?"));
            s.addChoiceQnA(new ChoiceQnA("Is this a range question?"));
            s.addRangeQnA(new RangeQnA("Is this a choice question?"));

            repositorySurvey.save(s);

            log.info("Survey found with findAll()");
            log.info("---------------------------------");
            Iterable<Survey> surveys = repositorySurvey.findAll();
            log.info("Print all TextQnA found in the Survey:");
            for(Survey survey : surveys) {
                for(TextQnA textQnA : survey.getTextList()) {
                    log.info("ID: " + textQnA.getId() + "\tQuestion: " + textQnA.getQuestionText());
                    log.info("Survey ID: " + survey.getSurveyID());
                    log.info("Question ID: " + textQnA.getId() + "\tQuestion: " + textQnA.getQuestionText());
                }
            }
            log.info("");
        };
    }
}
