package edu.miu.springdata.aspect;

import edu.miu.springdata.entity.ActivityLog;
import edu.miu.springdata.repository.ActivityLogRepository;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.time.LocalDate;

@Aspect
@Component
public class ActivityLogAspect {
    private ActivityLogRepository activityLogRepository;
    public ActivityLogAspect(ActivityLogRepository activityLogRepository){
        this.activityLogRepository = activityLogRepository;
    }

    @Pointcut("@annotation(edu.miu.springdata.aspect.ExecutionTime)")
    public void getPointCut() {
    }

    @Around("getPointCut()")
    public Object calculateExecTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();

        final StopWatch stopWatch = new StopWatch();

        //calculate method execution time
        stopWatch.start();
        Object result = proceedingJoinPoint.proceed();
        stopWatch.stop();

        ActivityLog activityLog = new ActivityLog(LocalDate.now(),
                methodSignature.getDeclaringType().getSimpleName() + "." + methodSignature.getName(),  // Class Name.Method Name
                stopWatch.getTotalTimeMillis());
        activityLogRepository.save(activityLog);
        return result;

    }
}
