package com.webshop.mapping.aspect;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Aspect
@Component
@RequiredArgsConstructor
public class WaaOffensiveWord {

    private static Map<String,String> offensiveWords = new HashMap<>();

    CacheLoader<String, String> loader= new CacheLoader<String, String>() {
        @Override
        public String load(String key) {
            return key.toUpperCase();
        }
    };

    LoadingCache<String, String> cache =  CacheBuilder.newBuilder()
            .expireAfterWrite(30,TimeUnit.SECONDS)
      .build(loader);


    public static Map<String,UserOffensiveCount> userOffensiveCountMapper = new HashMap<>();

    static {
        offensiveWords.put("Spring","Spring");
        offensiveWords.put("Lion","Lion");
        offensiveWords.put("Tiger","Tiger");
        offensiveWords.put("Road","Road");
    }
    private final HttpServletRequest httpServletRequest;

    @Pointcut(value  ="execution(* com.webshop.mapping.controller..*(..))")
    public void getPointCut() {
    }

    @Around("getPointCut()")
    public Object logging(ProceedingJoinPoint jp) throws Throwable {
        if(httpServletRequest.getRequestURI().indexOf("/api/v1/uaa")==-1 && httpServletRequest.getMethod().equals("POST") && httpServletRequest.getHeader("Authorization")!=null){
            for(Object ob :jp.getArgs()){
                boolean found = false;
                for(String word: offensiveWords.values()){
                    if(ob.toString().contains(word)){
                        String username = httpServletRequest.getUserPrincipal().getName();
                        if(userOffensiveCountMapper.containsKey(username)){
                            var userOffensiveCount = userOffensiveCountMapper.get(username);
                            Duration duration = Duration.between(LocalDateTime.now(), userOffensiveCount.getLastRequest());
                            Integer totalCount = userOffensiveCount.getCount();
                            if(duration.toMinutes()<30 && userOffensiveCount.getCount()<5){
                                userOffensiveCountMapper.put(username,new UserOffensiveCount(++totalCount,LocalDateTime.now()));
                            }
                        } else {
                            userOffensiveCountMapper.put(username,new UserOffensiveCount(1,LocalDateTime.now()));
                            found = true;
                            break;
                        }
                    }
                }
                if(found){
                    break;
                }
            }
            System.out.println("Here");
        }
        return jp.proceed();
    }
}
