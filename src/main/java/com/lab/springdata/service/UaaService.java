package com.lab.springdata.service;


import com.lab.springdata.model.LoginRequest;
import com.lab.springdata.model.LoginResponse;
import com.lab.springdata.model.RefreshTokenRequest;
import com.lab.springdata.security.JwtHelper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

public interface UaaService {

    public LoginResponse login(LoginRequest loginRequest);

    public LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}