package com.pprajapati.springsecurity.service.impl;

import com.pprajapati.springsecurity.domain.Role;
import com.pprajapati.springsecurity.domain.User;
import com.pprajapati.springsecurity.model.*;
import com.pprajapati.springsecurity.repo.RoleRepo;
import com.pprajapati.springsecurity.repo.UserRepo;
import com.pprajapati.springsecurity.security.helper.JwtHelper;
import com.pprajapati.springsecurity.service.UaaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

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
        new UsernamePasswordAuthenticationToken(loginRequest.getUserName(),
          loginRequest.getPassword())
      );

    } catch (BadCredentialsException e) {
      log.info("Bad Credentials");
      throw e;
    }

    final String accessToken = jwtHelper.generateToken(loginRequest.getUserName());
    final String refreshToken = jwtHelper.generateRefreshToken(loginRequest.getUserName());
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
    user.setUserName(signUpRequest.getUserName());
    user.setFirstName(signUpRequest.getFirstName());
    user.setLastName(signUpRequest.getLastName());

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
