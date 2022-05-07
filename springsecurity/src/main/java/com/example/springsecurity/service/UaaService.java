package com.example.springsecurity.service;

import com.example.springsecurity.models.LoginRequest;
import com.example.springsecurity.models.LoginResponse;
import com.example.springsecurity.models.RefreshTokenRequest;

public interface UaaService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
