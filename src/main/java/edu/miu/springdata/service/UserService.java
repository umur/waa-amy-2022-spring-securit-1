package edu.miu.springdata.service;


import edu.miu.springdata.dto.UserDto;
import edu.miu.springdata.dto.UserRespDto;
import edu.miu.springdata.entity.unidirectional.joincolumn.LoginRequest;
import edu.miu.springdata.entity.unidirectional.joincolumn.LoginResp;

import java.util.List;

public interface UserService {

    UserRespDto save(UserDto user);

    List<UserDto> findAll();

    UserDto findById(Long id);

    void deleteById(Long id);

    LoginResp login(LoginRequest loginRequest);


}
