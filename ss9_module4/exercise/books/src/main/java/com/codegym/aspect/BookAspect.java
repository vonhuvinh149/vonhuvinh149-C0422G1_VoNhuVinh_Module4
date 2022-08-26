package com.codegym.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BookAspect {

    @AfterReturning(pointcut = "execution(* com.codegym.controller.BookController.*(..))")
    public void logInForProcessing(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.err.println("Method " + methodName +" successfully.");
    }

}
