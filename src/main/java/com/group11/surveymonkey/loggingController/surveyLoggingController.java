package com.group11.surveymonkey.loggingController;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class surveyLoggingController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut(value="execution(* com.group11.surveymonkey.*.*(..))")
    public void pointCut(){};

    @Before("pointCut()")
    private void surveyLog(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        logger.info("Survey method " + methodName + " executed.");
    }
}
