package ru.evgen;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

@Component
@Aspect
public class LoggingAspect {
    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());


    @Pointcut("within(ru.evgen.service.FullNameComposer)")
    public void stringProcessingMethods() {
    }

    @After("stringProcessingMethods()")
    public void logMethodCall(JoinPoint joinPoint) {
        String methodName = joinPoint
                .getSignature()
                .getName();
        logger.log(Level.INFO, "method name: " + methodName);
    }

    @AfterReturning(pointcut = "execution(public String ru.evgen.service.FullNameComposer.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        logger.log(Level.INFO, "return result: " + result);
    }

    @Around("@annotation(LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis();
        logger.log(Level.INFO, joinPoint.getSignature() + " execution time " + executionTime + " ms ");
        return proceed;
    }


}
