package assignment.lab4.aspect;

import assignment.lab4.repository.ActivityLogRepo;
import assignment.lab4.entity.ActivityLog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Aspect
public class ExecutionTimeAspect {
    @Autowired
    private ActivityLogRepo activityLogRepo;

    @Pointcut("@annotation(assignment.lab4.aspect.annotation.ExecutionTime)")
    public void executionTimeAnnotation() {
    }

    @Around("executionTimeAnnotation()")
    public Object calculateExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //long start = System.nanoTime();
        long start = System.currentTimeMillis();
        var result = proceedingJoinPoint.proceed();
        long finish = System.currentTimeMillis() - start;//System.nanoTime();

        ActivityLog activityLog=new ActivityLog();
        activityLog.setDate(LocalDate.now());
        activityLog.setDuration(finish);
        activityLog.setOperation(proceedingJoinPoint.getSignature().getDeclaringTypeName()+" "+proceedingJoinPoint.getSignature().getName());
        activityLogRepo.save(activityLog);
        System.out.println(proceedingJoinPoint.getSignature().getName() + " takes ns: " + finish);
        System.out.println(proceedingJoinPoint.getSignature().getDeclaringTypeName()+ " takes ns: " + result);

        return result;
    }
}
