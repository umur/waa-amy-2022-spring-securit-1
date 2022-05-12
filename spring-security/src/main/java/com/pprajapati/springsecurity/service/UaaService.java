package com.pprajapati.springsecurity.service;

import com.pprajapati.springsecurity.dto.*;

public interface UaaService {
  LoginDtoResponse login(LoginDtoRequest loginRequest);

  LoginDtoResponse refreshToken(RefreshTokenDtoRequest refreshTokenRequest);

  SignUpDtoResponse signup(SignUpDtoRequest signUpRequest);
}
