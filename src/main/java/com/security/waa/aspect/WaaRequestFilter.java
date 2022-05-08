package com.security.waa.aspect;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@AllArgsConstructor
public class WaaRequestFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var user = request.getUserPrincipal().getName();
        var userRequestCount = WaaOffensiveWords.offensiveWordCount.get(user);
        if (userRequestCount.getCount() >=  5) {
            long timeOut = userRequestCount.timeOut();
            if (timeOut > 0) {
                filterChain.doFilter(request, response);
            }
        }
    }
}
