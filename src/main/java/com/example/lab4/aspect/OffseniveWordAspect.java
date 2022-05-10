package com.example.lab4.aspect;

import com.example.lab4.entity.Product;
import com.example.lab4.exceptions.RequestBannedException;
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
public class OffseniveWordAspect {
    private final HttpServletRequest httpServletRequest;

    private final List<String> words = List.of("spring", "test");

    public static Map<String, UserOffensiveCount> offensiveCount = new HashMap<>();

    @Pointcut("@annotation(com.example.lab4.aspect.annotation.OffensiveWarn)")
    public void jp(){}

    @Around("jp()")
    public Object check(ProceedingJoinPoint joinPoint) throws Throwable {
        if (httpServletRequest.getRequestURI().indexOf("/api/v1/auth") == -1 && httpServletRequest.getMethod().equals("POST") || httpServletRequest.getMethod().equals("PUT")) {
            var user = httpServletRequest.getUserPrincipal().getName();

            var args = joinPoint.getArgs();
            int index = 0;
            for (Object obj : args) {

                for (String w : words) {
                    if (obj.toString().contains(w)) {
                        Product p =((Product) obj);
                        p.setName(p.getName().replace("test","****"));
                        p.setName(p.getName().replace("spring","*****"));
                        if(offensiveCount.containsKey(user)){
                            var userRequestCount = offensiveCount.get(user);
                            var totalCount = userRequestCount.getCount();
                            offensiveCount.put(user, new UserOffensiveCount(++totalCount, LocalDateTime.now()));
                            if (offensiveCount.get(user).getCount() >= 5) {
                                long timeOut = offensiveCount.get(user).timeOut();
                                if (timeOut > 0) {
                                    throw new RequestBannedException("User has been banned");
                                }
                            }
                        }else {
                            offensiveCount.put(user, new UserOffensiveCount(1, LocalDateTime.now()));
                        }

                        args[index] = p;
                        joinPoint.proceed(args);
                    }

                }
                index++;
            }

        }
        return joinPoint.proceed();
    }
}
