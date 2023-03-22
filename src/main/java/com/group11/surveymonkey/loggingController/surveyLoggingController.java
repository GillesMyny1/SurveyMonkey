package com.group11.surveymonkey.loggingController;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.hibernate.mapping.Join;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class surveyLoggingController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut(value="execution(* com.group11.surveymonkey.*.*(..))")
    public void applicationPointCut(){};
    @Before("applicationPointCut()")
    private void executionLog(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        logger.info("Survey method " + methodName + " executed.");
    }

    @Around("applicationPointCut()")
    private void timingLog(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.nanoTime();
        joinPoint.proceed();
        long endTime = System.nanoTime();
        String methodName = joinPoint.getSignature().getName();
        logger.info("Survey Method " + methodName + " executed in " + ((endTime - startTime) / 100000) + " ms");
    }
}
