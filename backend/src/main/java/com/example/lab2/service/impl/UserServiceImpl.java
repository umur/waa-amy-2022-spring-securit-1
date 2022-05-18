package com.example.lab2.service.impl;

import com.example.lab2.dto.User.UserDTO;
import com.example.lab2.dto.User.UserSaveDTO;
import com.example.lab2.entity.User;
import com.example.lab2.repository.UserRepository;
import com.example.lab2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public void save(UserSaveDTO user) {
        userRepository.save(modelMapper.map(user, User.class));
    }

    @Override
    public void delete(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public void update(int id, UserDTO userDTO) {
//        userRepository.save(modelMapper.map(userDTO, User.class));
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()){
            user.get().setFirstname(userDTO.getFirstname());
            user.get().setLastname(userDTO.getLastname());
            user.get().setEmail(userDTO.getEmail());
            user.get().setPassword(userDTO.getPassword());
            user.get().setAddress(userDTO.getAddress());
            user.get().setReviewList(userDTO.getReviewList());
            userRepository.save(user.get());
        }
    }

    @Override
    public List<UserDTO> getAll() {
        return StreamSupport
                .stream(userRepository.findAll().spliterator(), false)
                .map(u -> modelMapper.map(u, UserDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getById(int id) {
        var r = userRepository.findById(id);
        return r.isPresent() ? modelMapper.map(r.get(), UserDTO.class) : null;
    }
}
