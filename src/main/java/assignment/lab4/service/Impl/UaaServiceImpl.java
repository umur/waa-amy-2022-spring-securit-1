package assignment.lab4.service.Impl;


import assignment.lab4.entity.User;
import assignment.lab4.model.LoginRequest;
import assignment.lab4.model.LoginResponse;
import assignment.lab4.model.RefreshTokenRequest;
import assignment.lab4.repository.UserRepo;
import assignment.lab4.security.JwtHelper;
import assignment.lab4.service.UaaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UaaServiceImpl implements UaaService {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtHelper jwtHelper;
    @Autowired
    private UserRepo userRepo;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        var loginResponse = new LoginResponse("", "");
        try {
            var result = authenticationManager.authenticate(

                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
                            loginRequest.getPassword())
            );
            final String accessToken = jwtHelper.generateToken(loginRequest.getEmail());
            final String refreshToken = jwtHelper.generateRefreshToken(loginRequest.getEmail());
            loginResponse = new LoginResponse(accessToken, refreshToken);
        } catch (BadCredentialsException e) {
            log.info("Bad Credentials");
            loginResponse = new LoginResponse("Wrong Credentials", "");
        }


        return loginResponse;
    }

    @Override
    public void signUp(User user) {
        userRepo.save(user);
    }

    @Override
    public List<User> getAll() {
        return (List<User>) userRepo.findAll();
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
