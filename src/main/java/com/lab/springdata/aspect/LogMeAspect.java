package com.lab.springdata.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class LogMeAspect {

        @Pointcut("@annotation(com.lab.springdata.aspect.annotation.LogMe)")
        public void a(){}

        @After("a()")
        public void log(JoinPoint joinPoint){
            System.out.println("Method Name: " + joinPoint.getSignature().getName());
        }
}
