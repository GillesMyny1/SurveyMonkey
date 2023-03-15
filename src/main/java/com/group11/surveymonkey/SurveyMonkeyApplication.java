package com.group11.surveymonkey;

import com.group11.surveymonkey.entity.*;
import com.group11.surveymonkey.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.w3c.dom.ranges.Range;

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
            Survey s = new Survey("Default Survey");

            TextQnA tq = new TextQnA("Is this a text question?");
            RangeQnA rq = new RangeQnA("How are you feeling?");
            rq.setMinimum(1);
            rq.setMaximum(10);
            rq.setStep(1);
            ChoiceQnA cq = new ChoiceQnA("Which suits you best?");

            TextAnswer ta = new TextAnswer("Yes it does.");
            tq.addTextAnswer(ta);
            ta.setTextQnA(tq);
            RangeAnswer ra = new RangeAnswer(5);
            rq.addRangeAnswer(ra);
            ra.setRangeQnA(rq);
            // TODO: Frank, add ChoiceAnswer material as above

            s.addTextQnA(tq);
            s.addRangeQnA(rq);
            s.addChoiceQnA(cq);

            textAnswerRepository.save(ta);
            rangeAnswerRepository.save(ra);
            // TODO: Frank, save ChoiceAnswer as above
            textQnARepository.save(tq);
            rangeQnARepository.save(rq);
            choiceQnARepository.save(cq);
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
                    // TODO: Frank, print the ChoiceAnswer as above
                }
            }
            log.info("");
        };
    }
}
