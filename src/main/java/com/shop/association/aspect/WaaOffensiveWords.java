package com.shop.association.aspect;

import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class WaaOffensiveWords {
    private final HttpServletRequest httpServletRequest;

    public static Map<String, UserRequestCount> offensiveWordCount = new HashMap<>();

    @Pointcut(value = "execution(* com.shop.association.service.impl..*(..))")
    public void postHeaderAspect() {
    }

    @Around("postHeaderAspect()")
    public Object logging(ProceedingJoinPoint jp) throws Throwable {
        if (httpServletRequest.getRequestURI().indexOf("/api/v1/uaa") == -1 && httpServletRequest.getMethod().equals("POST") || httpServletRequest.getMethod().equals("PUT")) {

            var user = httpServletRequest.getUserPrincipal().getName();

            var args = jp.getArgs();

            for (Object ob : args) {
                for (String s : getOffensiveWords()) {
                    if (ob.toString().contains(s)) {
                        if (offensiveWordCount.containsKey(user)) {
                            var userRequestCount = offensiveWordCount.get(user);
                            var totalCount = userRequestCount.getCount();
                            offensiveWordCount.put(user, new UserRequestCount(++totalCount, LocalDateTime.now()));
                        }else {
                            offensiveWordCount.put(user, new UserRequestCount(1, LocalDateTime.now()));
                        }
                    }
                }
            }

        }
        return jp.proceed();
    }

    public List<String> getOffensiveWords() {
        return List.of("spring","bug","repeat","smoke");
    }

}
