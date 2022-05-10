package com.pprajapati.springsecurity.controller;

import com.pprajapati.springsecurity.model.*;
import com.pprajapati.springsecurity.service.UaaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/uaa")
@CrossOrigin
public class UaaController {
  private final UaaService uaaService;

  public UaaController(UaaService uaaService) {
    this.uaaService = uaaService;
  }

  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
    try {
      var loginResponse = uaaService.login(loginRequest);
      return ResponseEntity.ok().body(loginResponse);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new LoginFailedResponse("Login failed"));
    }
  }

  @PostMapping("/refreshToken")
  public LoginResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest){
    return uaaService.refreshToken(refreshTokenRequest);
  }

  @PostMapping("/signup")
  public SignUpResponse signup(@RequestBody SignUpRequest signUpRequest) {
    return uaaService.signup(signUpRequest);
  }
}
