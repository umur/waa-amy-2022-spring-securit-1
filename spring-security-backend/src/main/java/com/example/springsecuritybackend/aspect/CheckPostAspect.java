package com.example.springsecuritybackend.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CheckPostAspect {

//    @Before("execution(* com.example.lab2.service.*.*(..))")
//    public void checkPost(JoinPoint joinPoint) throws AopIsAwesomeHeaderException {
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//
//        if (request.getMethod().equalsIgnoreCase("post")){
//            Map<String, String> headers = Collections.list(request.getHeaderNames()).stream().collect(Collectors.toMap(h -> h, request::getHeader));
//            boolean[] containHeader = new boolean []{false};
//
//            headers.forEach((k, v) -> {
//                if (k.equalsIgnoreCase("AOP-IS-AWESOME") || v.equalsIgnoreCase("AOP-IS-AWESOME"))
//                    containHeader[0] = true;
//            });
//
//            if(!containHeader[0]){
//                throw new AopIsAwesomeHeaderException("Exception Aop Is AwesomeHeader");
//            }
//        }
//
//    }

}
