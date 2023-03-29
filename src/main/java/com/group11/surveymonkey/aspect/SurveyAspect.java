package com.group11.surveymonkey.aspect;

import com.group11.surveymonkey.entity.*;
import org.aspectj.lang.*;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SurveyAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* com.group11.surveymonkey.repository.SurveyRepository.*(..))")
    public void surveyPointCut(){}

    @Around("surveyPointCut() && args(input))")
    private void surveySaveLog(ProceedingJoinPoint joinPoint, Survey input) throws Throwable {
        long startTime = System.nanoTime();
        Object results = joinPoint.proceed();
        long endTime = System.nanoTime();
        String methodName = joinPoint.getSignature().getName();
        String surveyString = "Survey method '" + methodName + "' executed in " + ((endTime - startTime) / 100000) +
                " ms with input: " + "\nID: " + input.getSurveyID() + ", Name: " + input.getSurveyName();
        logger.info(surveyString);
    }

    @Pointcut("execution(* com.group11.surveymonkey.repository.ChoiceQnARepository.*(..))")
    public void choiceQnAPointCut(){}

    @After("choiceQnAPointCut() && args(input)")
    private void choiceQnALogging(ChoiceQnA input){
        String log = "\n\t\tQuestion ID: " + input.getId() + "\n\t\tQuestion Text: " + input.getQuestionText() + "\n\t\tChoices: ";
        for(String choice : input.getChoices()){
            log = log.concat("\n\t\t\t" + choice);
        }
        if(!input.getChoiceAnswers().isEmpty()) {
            log = log.concat("\n\t\tAnswers: ");
            for (ChoiceAnswer answer : input.getChoiceAnswers()) {
                log = log.concat("\n\t\t\tAnswer ID: " + answer.getId() + "\n\t\t\tAnswer: " + answer.getAnswer());
            }
        }else{
            log.concat("\n\t\tNo answers");
        }
        logger.info(log);
    }

    @Pointcut("execution(* com.group11.surveymonkey.repository.TextQnARepository.*(..))")
    public void textQnAPointCut(){}

    @After("textQnAPointCut() && args(input)")
    private void textQnALogging(TextQnA input){
        String log = "\n\t\tQuestion ID: " + input.getId() + "\n\t\tQuestion Text: " + input.getQuestionText();
        if(!input.getTextAnswers().isEmpty()) {
            log = log.concat("\n\t\tAnswers: ");
            for (TextAnswer answer : input.getTextAnswers()) {
                log = log.concat("\n\t\t\tAnswer ID: " + answer.getId() + "\n\t\t\tAnswer: " + answer.getAnswer());
            }
        }else{
            log.concat("\n\t\tNo answers");
        }
        logger.info(log);
    }

    @Pointcut("execution(* com.group11.surveymonkey.repository.RangeQnARepository.*(..))")
    public void rangeQnAPointCut(){}

    @After("rangeQnAPointCut() && args(input)")
    private void rangeQnALogging(RangeQnA input){
        String log = "\n\t\tQuestion ID: " + input.getId() + "\n\t\tQuestion Text: " + input.getQuestionText() + "\n\t\tRange: [" + input.getMinimum() + ", " + input.getMaximum() + "]" + "\n\t\tStep: " + input.getStep();
        if(!input.getRangeAnswers().isEmpty()) {
            log = log.concat("\n\t\tAnswers: ");
            for (RangeAnswer answer : input.getRangeAnswers()) {
                log = log.concat("\n\t\t\tAnswer ID: " + answer.getId() + "\n\t\t\tAnswer: " + answer.getAnswer());
            }
        }else{
            log.concat("\n\t\tNo answers");
        }
        logger.info(log);

    }
}