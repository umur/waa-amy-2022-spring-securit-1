package com.security.waa.service;

import com.security.waa.model.*;

public interface UaaService {
    LoginResponse login(LoginRequest loginRequest);

    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);

    SignUpResponse signup(SignUpRequest signUpRequest);
}
