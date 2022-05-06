package com.shop.association.service.impl;

import com.shop.association.domain.bidirection.joincolumn.User3;
import com.shop.association.model.LoginRequest;
import com.shop.association.model.LoginResponse;
import com.shop.association.repository.User3Repo;
import com.shop.association.security.JwtHelper;
import com.shop.association.service.User3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class User3ServiceImpl implements User3Service {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtHelper jwtHelper;

    private final User3Repo user3Repo;

    @Override
    public void save(User3 user3) {
        user3Repo.save(user3);
    }

    @Override
    public void update(User3 user3, int id) {
        user3.setId(id);
        user3Repo.save(user3);
    }

    @Override
    public void delete(int id) {
        user3Repo.deleteById(id);
    }

    @Override
    public List<User3> getAll() {
        return (List<User3>) user3Repo.findAll();
    }

    @Override
    public User3 getById(int id) {
        return user3Repo.findById(id).orElse(null);
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        try {
            var result = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
                            loginRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            System.out.println("Bad Credentials");
        }

        final String accessToken = jwtHelper.generateToken(loginRequest.getEmail());
        final String refreshToken = jwtHelper.generateRefreshToken(loginRequest.getEmail());
        var loginResponse = new LoginResponse(accessToken, refreshToken);
        return loginResponse;
    }
}
