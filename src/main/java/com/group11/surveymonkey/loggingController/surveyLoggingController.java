package com.group11.surveymonkey.loggingController;

import com.group11.surveymonkey.entity.Survey;
import org.aspectj.lang.*;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class surveyLoggingController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut(value="execution(* com.group11.surveymonkey.repository.SurveyRepository.*(..))")
    public void surveyPointCut(){};

    @Before("surveyPointCut() && args(input))")
    private void outputLog(JoinPoint joinPoint, Survey input){
        String methodName = joinPoint.getSignature().getName();
        logger.info("Survey method \'" + methodName + "\' executed with input: " + input.getSurveyName());
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
