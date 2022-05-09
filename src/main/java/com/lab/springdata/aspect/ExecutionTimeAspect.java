package com.lab.springdata.aspect;

import com.lab.springdata.entity.Activitylog;
import com.lab.springdata.service.impl.ActivitylogService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class ExecutionTimeAspect {
    private final ActivitylogService activitylogService;
    /*
    @Pointcut("@annotation(com.lab.springdata.aspect.annotation.ExecutionTimeAnnotation)")
    public void eTA() {
    }

     */
    @Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void eTA(){}

    @Around("eTA()")
    public void calculateExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //System.out.println("1");
        long start = System.nanoTime();
        //System.out.println("2");
        proceedingJoinPoint.proceed();
        //System.out.println("3");
        long finish = System.nanoTime();
        //System.out.println("4");
        System.out.println(proceedingJoinPoint.getSignature().getName() + " takes ns: " + finish);
        Activitylog activitylog = new Activitylog();
        activitylog.setOperation(proceedingJoinPoint.getSignature().getName());
        activitylog.setDuration(finish-start);
        //if(proceedingJoinPoint.get)
        activitylogService.save(activitylog);
    }


}
