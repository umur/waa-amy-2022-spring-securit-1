package com.security.waa.service.impl;

import com.security.waa.entity.Role;
import com.security.waa.entity.User;
import com.security.waa.model.*;
import com.security.waa.repository.RoleRepo;
import com.security.waa.repository.UserRepo;
import com.security.waa.security.AwesomeUserDetails;
import com.security.waa.security.AwesomeUserDetailsService;
import com.security.waa.security.JwtHelper;
import com.security.waa.service.UaaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UaaServiceImpl implements UaaService {
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;

    private final JwtHelper jwtHelper;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        try {
            var result = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
                            loginRequest.getPassword())
            );

        } catch (BadCredentialsException e) {
            log.info("Bad Credentials");
            throw e;
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

    @Override
    public SignUpResponse signup(SignUpRequest signUpRequest) {
        User user = new User();
        user.setEmail(signUpRequest.getEmail());
        user.setFirstname(signUpRequest.getFirstname());
        user.setLastname(signUpRequest.getLastname());

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        var encodedPwd = passwordEncoder.encode(signUpRequest.getPassword());
        user.setPassword(encodedPwd);

        var userRole = roleRepo.findById(signUpRequest.getRoleId()).orElse(null);
        var roles = new ArrayList<Role>();
        roles.add(userRole);
        user.setRole(roles);

        userRepo.save(user);
        return new SignUpResponse(user);
    }
}
