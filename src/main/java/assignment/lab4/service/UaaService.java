package assignment.lab4.service;


import assignment.lab4.entity.User;
import assignment.lab4.model.LoginRequest;
import assignment.lab4.model.LoginResponse;
import assignment.lab4.model.RefreshTokenRequest;

import java.util.List;

public interface UaaService {
    LoginResponse login(LoginRequest loginRequest);

    public void signUp(User user);
public List<User> getAll();
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
