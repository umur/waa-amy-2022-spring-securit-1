package edu.miu.springdata.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
public class PostRequestCheckerAspect {
    private HttpServletRequest httpServletRequest;
    PostRequestCheckerAspect(HttpServletRequest httpServletRequest){
        this.httpServletRequest = httpServletRequest;
    }

    @Pointcut(value  ="execution(* edu.miu.springdata.service.impl..*(..))")
    public void getPointCut() {
    }

    @Around("getPointCut()")
    public Object postRequestCheck(ProceedingJoinPoint jp) throws Throwable {
        if(httpServletRequest.getMethod().equals("POST") && httpServletRequest.getHeader("AOP-IS-AWESOME")==null){
            throw new AopIsAwesomeHeaderException("AOP-IS-AWESOME header is not present ");
        }
        return jp.proceed();
    }
}
