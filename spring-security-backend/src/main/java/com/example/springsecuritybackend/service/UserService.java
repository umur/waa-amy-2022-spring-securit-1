package com.example.springsecuritybackend.service;

import com.example.springsecuritybackend.dto.UserDTO;
import com.example.springsecuritybackend.dto.UserToSaveDTO;

import java.util.List;

public interface UserService {
    void save(UserToSaveDTO user);
    void delete(int id);
    void update(int id, UserDTO userDTO);
    List<UserDTO> getAll();
    UserDTO getById(int id);

}
