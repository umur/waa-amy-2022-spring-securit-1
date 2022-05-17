package com.example.springsecurity.service;

import com.example.springsecurity.domain.LoginRequest;
import com.example.springsecurity.domain.LoginResponse;
import com.example.springsecurity.dto.UserDto;
import com.example.springsecurity.dto.UserDtoResponse;

import java.util.List;

public interface UserService {
    List<UserDto> findAll();

    UserDto findById(Long id);

    UserDtoResponse save(UserDto user);

    void remove(Long id);

    LoginResponse login(LoginRequest loginRequest);
}
