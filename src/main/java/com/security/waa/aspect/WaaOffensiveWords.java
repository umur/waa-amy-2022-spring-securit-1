package com.security.waa.aspect;

import lombok.AllArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Aspect
@Component
@AllArgsConstructor
public class WaaOffensiveWords {
    private final HttpServletRequest httpServletRequest;
    public static Map<String, UserOffensiveCount> offensiveWordCount = new HashMap<>();

    private final List<String> offensiveWords = List.of("spring", "dota");

    @Pointcut(value = "execution(* com.security.waa.controller..*(..))")
    public void controller() {
    }

    @Around("controller()")
    public Object logging(ProceedingJoinPoint jp) throws Throwable {
        if (httpServletRequest.getRequestURI().indexOf("/api/v1/uaa") == -1 && httpServletRequest.getMethod().equals("POST") || httpServletRequest.getMethod().equals("PUT")) {

            var user = httpServletRequest.getUserPrincipal().getName();

            var args = jp.getArgs();

            for (Object ob : args) {
                for (String s : offensiveWords) {
                    if (ob.toString().contains(s)) {
                        if (offensiveWordCount.containsKey(user)) {
                            var userRequestCount = offensiveWordCount.get(user);
                            var totalCount = userRequestCount.getCount();
                            offensiveWordCount.put(user, new UserOffensiveCount(++totalCount, LocalDateTime.now()));
                        }else {
                            offensiveWordCount.put(user, new UserOffensiveCount(1, LocalDateTime.now()));
                        }
                    }
                }
            }

        }
        return jp.proceed();
    }
}
