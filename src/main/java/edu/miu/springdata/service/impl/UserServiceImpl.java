package edu.miu.springdata.service.impl;

import edu.miu.springdata.dto.UserDto;
import edu.miu.springdata.dto.UserRespDto;
import edu.miu.springdata.entity.unidirectional.joincolumn.LoginRequest;
import edu.miu.springdata.entity.unidirectional.joincolumn.LoginResp;
import edu.miu.springdata.entity.unidirectional.joincolumn.User3;
import edu.miu.springdata.repository.UserRepository;
import edu.miu.springdata.security.JwtTokenUtil;
import edu.miu.springdata.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;
    private AuthenticationManager authenticationManager;
    private JwtTokenUtil jwtTokenUtil;



    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper){
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<UserDto> findAll() {
        var users = userRepository.findAll();
        Type listType = new TypeToken<List<UserDto>>(){}.getType();
        return modelMapper.map(users,listType);
    }

    @Override
    public UserDto findById(Long id) {
        Optional<User3> user = userRepository.findById(id);
        return modelMapper.map(userRepository.save(user.get()),UserDto.class);
    }

    @Override
    public UserRespDto save(UserDto userDto) {
        User3 user = modelMapper.map(userDto, User3.class);
        return modelMapper.map(userRepository.save(user),UserRespDto.class);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public LoginResp login(LoginRequest loginRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
                            loginRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new RuntimeException("Bad Credentials");
        }
        final String accessToken = jwtTokenUtil.generateToken(loginRequest.getEmail());
        final String refreshToken = jwtTokenUtil.generateRefreshToken(loginRequest.getEmail());
        var loginResponse = new LoginResp(accessToken, refreshToken);
        return loginResponse;

    }
}
