package com.example.lab2.aspect;

import com.example.lab2.entity.ActivityLog;
import com.example.lab2.repository.ActivityLogRepository;
import lombok.AllArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;


@AllArgsConstructor
@Aspect
@Component
public class ExecutionTimeAspect {

    private final ActivityLogRepository activityLogRepository;

//    @Pointcut("execution(* com.example.lab2.controller.*.*(..))")

    @Pointcut("@annotation(com.example.lab2.aspect.annotation.ExecutionTime)")
    public void executionTimeAnnotation() {
    }

    @Around("executionTimeAnnotation()")
    public Object calculateExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        Instant start = Instant.now();
        var result = proceedingJoinPoint.proceed();
        Instant end = Instant.now();

        Duration duration = Duration.between(start, end);

        String operation = """
                [%s | method: %s]
                """.formatted(proceedingJoinPoint.getTarget().getClass(), proceedingJoinPoint.getSignature().getName());

        activityLogRepository.save(new ActivityLog(LocalDateTime.now(), operation, duration));

//        System.out.println(duration.toMillis());

        return result;
    }
}
