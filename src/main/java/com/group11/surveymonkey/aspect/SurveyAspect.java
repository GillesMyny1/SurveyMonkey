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

    @Pointcut(value="execution(* com.group11.surveymonkey.repository.SurveyRepository.*(..))")
    public void surveyPointCut(){}

    @Before("surveyPointCut() && args(input))")
    private void outputLog(JoinPoint joinPoint, Survey input) {
        String methodName = joinPoint.getSignature().getName();
        String surveyString = "Survey method '" + methodName + "' executed with input: " + "\nID: " + input.getSurveyID() + ", Name: " + input.getSurveyName();
        //TextQnA
        if(!input.getTextList().isEmpty()){
            surveyString = surveyString.concat("\n\tText Questions:");
            for(TextQnA textQnA : input.getTextList()){
                surveyString = surveyString.concat("\n\t\tQuestion ID: " + textQnA.getId() + "\n\t\tQuestion Text: " + textQnA.getQuestionText());
                if(!textQnA.getTextAnswers().isEmpty()){
                    surveyString = surveyString.concat("\n\t\tAnswer: ");
                    for(TextAnswer textAnswer : textQnA.getTextAnswers()){
                        surveyString = surveyString.concat("\n\t\t\tAnswer ID: " + textAnswer.getId() + "\n\t\t\tAnswer: " + textAnswer.getAnswer());
                    }
                }else{
                    surveyString = surveyString.concat("\n\t\tNo answers");
                }
                surveyString = surveyString.concat("\n\t\tNo text questions");
            }
        }
        //RangeQnA
        if(!input.getRangeList().isEmpty()){
            surveyString = surveyString.concat("\n\tRange Questions: ");
            for(RangeQnA rangeQnA : input.getRangeList()){
                surveyString = surveyString.concat("\n\t\tQuestion ID: " + rangeQnA.getId() + "\n\t\tQuestion Text: " + rangeQnA.getQuestionText() + "\n\t\tRange: [" + rangeQnA.getMinimum() + ", " + rangeQnA.getMaximum() + "]" + "\n\t\tStep: " + rangeQnA.getStep());
                if(!rangeQnA.getRangeAnswers().isEmpty()){
                    surveyString = surveyString.concat("Answers: ");
                    for(RangeAnswer rangeAnswer : rangeQnA.getRangeAnswers()){
                        surveyString = surveyString.concat("\n\t\t\tAnswer ID: " + rangeAnswer.getId() + "\n\t\t\tAnswer: " + rangeAnswer.getAnswer());
                    }
                }else{
                    surveyString = surveyString.concat("\n\t\tNo answers");
                }
            }
        }else{
            surveyString = surveyString.concat("\n\t\tNo range questions");
        }
        //ChoiceQnA
        if (!input.getChoiceList().isEmpty()) {
            surveyString = surveyString.concat("\n\tChoice Questions:");
            for (ChoiceQnA choiceQnA : input.getChoiceList()) {
                surveyString = surveyString.concat("\n\t\tQuestion ID: " + choiceQnA.getId() + "\n\t\tQuestion Text: " + choiceQnA.getQuestionText() + "\n\t\tChoices: ");
                for (String choice : choiceQnA.getChoices()) {
                    surveyString = surveyString.concat("\n\t\t\t" + choice);
                }
                if (!choiceQnA.getChoiceAnswers().isEmpty()) {
                    surveyString = surveyString.concat("\n\t\tAnswers: ");
                    for (ChoiceAnswer choiceAnswer : choiceQnA.getChoiceAnswers()) {
                        surveyString = surveyString.concat("\n\t\t\tAnswer ID: " + choiceAnswer.getId() + "\n\t\t\tAnswer: " + choiceAnswer.getAnswer());
                    }
                } else {
                    surveyString = surveyString.concat("\n\t\tNo answers");
                }
            }
        }else{
            surveyString = surveyString.concat("\n\t\tNo choice questions");
        }
        logger.info(surveyString);
    }
    @Around("surveyPointCut()")
    private Object timingLog(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.nanoTime();
        Object results = joinPoint.proceed();
        long endTime = System.nanoTime();
        String methodName = joinPoint.getSignature().getName();
        logger.info("Survey Method " + methodName + " executed in " + ((endTime - startTime) / 100000) + " ms");
        return results;
    }
}