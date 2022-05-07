package com.example.springsecurity.aspect;
import com.example.springsecurity.entity.Activity;
import com.example.springsecurity.service.LogService;
import lombok.AllArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
@AllArgsConstructor
public class AspectLogger {
    private final LogService logService;

    @Pointcut("@annotation(com.example.springsecurity.aspect.annotation.Logger)")
    public void logMeAnnotation(){}

    @Around("logMeAnnotation()")
    public void logMeAnnotation(JoinPoint joinPoint) {
        Activity activity = new Activity();
        activity.setDate(LocalDateTime.now());
        activity.setOperation(joinPoint.getSignature().getName());
        logService.save(activity);
        System.out.println("Method Name : " + joinPoint.getSignature().getName());
    }
}
