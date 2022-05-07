package assignment.lab4.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class CheckPostAspect {

    @Pointcut("execution(* assignment.lab4.service.*.*(..))")
    public void checkPostAnnotation() {
    }

    @Around("checkPostAnnotation()")
    public Object log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        if(proceedingJoinPoint.getSignature().getName()=="getAll")
        {
            System.out.println("helloooo");
        }
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String header = request.getHeader("sessionGuid");
        System.out.println(proceedingJoinPoint.getSignature().getName()+"header");
        var result = proceedingJoinPoint.proceed();
        System.out.println(request+"hellosdsdsdsd");
        System.out.println(request.getHeaderNames()+"hellosdsdsdsd");
        System.out.println(    RequestContextHolder.getRequestAttributes()+"jjj");

        return         result ;

    }


}
