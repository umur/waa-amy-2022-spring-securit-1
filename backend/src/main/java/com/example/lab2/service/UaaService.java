package com.example.lab2.service;

import com.example.lab2.model.LoginRequest;
import com.example.lab2.model.LoginResponse;
import com.example.lab2.model.RefreshTokenRequest;

public interface UaaService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
