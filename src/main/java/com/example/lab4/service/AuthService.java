package com.example.lab4.service;

import com.example.lab4.model.LoginRequest;
import com.example.lab4.model.LoginResponse;
import com.example.lab4.model.RefreshToken;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshToken refreshTokenRequest);
}
