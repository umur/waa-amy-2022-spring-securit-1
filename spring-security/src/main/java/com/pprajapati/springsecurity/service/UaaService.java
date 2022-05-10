package com.pprajapati.springsecurity.service;

import com.pprajapati.springsecurity.model.*;

public interface UaaService {
  LoginResponse login(LoginRequest loginRequest);

  LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);

  SignUpResponse signup(SignUpRequest signUpRequest);
}
