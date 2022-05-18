package com.example.lab2.service.impl;

import com.example.lab2.model.LoginRequest;
import com.example.lab2.model.LoginResponse;
import com.example.lab2.model.RefreshTokenRequest;
import com.example.lab2.security.JwtHelper;
import com.example.lab2.service.UaaService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class UaaServiceImpl implements UaaService {

    private final AuthenticationManager authenticationManager;
    private final JwtHelper jwtHelper;

    public UaaServiceImpl(AuthenticationManager authenticationManager, JwtHelper jwtHelper) {
        this.authenticationManager = authenticationManager;
        this.jwtHelper = jwtHelper;
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        try {
            var result = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
                            loginRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
//            log.info("Bad Credentials");
        }

        final String accessToken = jwtHelper.generateToken(loginRequest.getEmail());
        final String refreshToken = jwtHelper.generateRefreshToken(loginRequest.getEmail());
        var loginResponse = new LoginResponse(accessToken, refreshToken);
        return loginResponse;
    }

    @Override
    public LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
        boolean isRefreshTokenValid = jwtHelper.validateToken(refreshTokenRequest.getRefreshToken());
        if (isRefreshTokenValid) {
            final String accessToken = jwtHelper.generateToken(jwtHelper.getSubject(refreshTokenRequest.getRefreshToken()));
            var loginResponse = new LoginResponse(accessToken, refreshTokenRequest.getRefreshToken());
            return loginResponse;
        }
        return new LoginResponse();
    }
}
