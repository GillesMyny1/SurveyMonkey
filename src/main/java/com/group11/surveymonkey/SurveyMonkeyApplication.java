package com.group11.surveymonkey;

import com.group11.surveymonkey.entity.*;
import com.group11.surveymonkey.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SurveyMonkeyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SurveyMonkeyApplication.class, args);
    }

    public static final Logger log = LoggerFactory.getLogger(SurveyMonkeyApplication.class);

    @Bean
    public CommandLineRunner demo(SurveyRepository repositorySurvey, TextQnARepository textQnARepository, RangeQnARepository rangeQnARepository,
                                  ChoiceQnARepository choiceQnARepository, TextAnswerRepository textAnswerRepository, RangeAnswerRepository
                                  rangeAnswerRepository, ChoiceAnswerRepository choiceAnswerRepository) {
        return (args) -> {
            Survey s = new Survey("Default App Survey");

            TextQnA tq = new TextQnA("Is this a text question?");
            RangeQnA rq = new RangeQnA("How are you feeling?");
            rq.setMinimum(1);
            rq.setMaximum(10);
            rq.setStep(1);
            ChoiceQnA cq = new ChoiceQnA("Which suits you best?");
            ArrayList<String> choices = new ArrayList<>();
            choices.add("Red");
            choices.add("Blue");
            choices.add("Yellow");
            cq.setChoices(choices);

            TextAnswer ta = new TextAnswer("Yes it is.");
            tq.addTextAnswer(ta);
            ta.setTextQnA(tq);
            RangeAnswer ra = new RangeAnswer(5);
            rq.addRangeAnswer(ra);
            ra.setRangeQnA(rq);
            ChoiceAnswer ca = new ChoiceAnswer("Red");
            cq.addChoiceAnswer(ca);
            ca.setChoiceQnA(cq);

            s.addTextQnA(tq);
            s.addRangeQnA(rq);
            s.addChoiceQnA(cq);

            repositorySurvey.save(s);

            log.info("Survey found with findAll()");
            log.info("---------------------------------");
            Iterable<Survey> surveys = repositorySurvey.findAll();
            for(Survey survey : surveys) {
                for(TextQnA textQnA : survey.getTextList()) {
                    log.info("Survey ID: " + survey.getSurveyID());
                    log.info("Text Question ID: " + textQnA.getId() + "\tQuestion: " + textQnA.getQuestionText());
                    for(TextAnswer textAnswer : textQnA.getTextAnswers()) {
                        log.info("Text Answer ID: " + textAnswer.getId() + "\tAnswer: " + textAnswer.getAnswer());
                    }
                }
                for(RangeQnA rangeQnA : survey.getRangeList()) {
                    log.info("Survey ID: " + survey.getSurveyID());
                    log.info("Range Question ID: " + rangeQnA.getId() + "\tQuestion: " + rangeQnA.getQuestionText());
                    for(RangeAnswer rangeAnswer : rangeQnA.getRangeAnswers()) {
                        log.info("Range Answer ID: " + rangeAnswer.getId() + "\tAnswer: " + rangeAnswer.getAnswer());
                    }
                }
                for(ChoiceQnA choiceQnA : survey.getChoiceList()) {
                    log.info("Survey ID: " + survey.getSurveyID());
                    log.info("Choice Question ID: " + choiceQnA.getId() + "\tQuestion: " + choiceQnA.getQuestionText());
                    for(ChoiceAnswer choiceAnswer : choiceQnA.getChoiceAnswers()){
                        log.info("Range Answer ID: "+ choiceAnswer.getId() + "\tAnswer: " + choiceAnswer.getAnswer());
                        log.info(choiceQnA.getChoices().get(0));
                    }
                }
            }
            log.info("");
        };
    }
}
