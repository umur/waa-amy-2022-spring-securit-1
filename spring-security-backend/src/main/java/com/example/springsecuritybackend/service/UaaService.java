package com.example.springsecuritybackend.service;

import com.example.springsecuritybackend.otherModel.LoginRequest;
import com.example.springsecuritybackend.otherModel.LoginResponse;
import com.example.springsecuritybackend.otherModel.RefreshTokenRequest;

public interface UaaService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
