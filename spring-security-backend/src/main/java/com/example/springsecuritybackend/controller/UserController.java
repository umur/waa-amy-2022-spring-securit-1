package com.example.springsecuritybackend.controller;

import com.example.springsecuritybackend.aspect.annotation.ExecutionTime;
import com.example.springsecuritybackend.dto.UserDTO;
import com.example.springsecuritybackend.dto.UserToSaveDTO;
import com.example.springsecuritybackend.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @ExecutionTime
    public List<UserDTO> getAll(){
        return userService.getAll();
    }

    @PostMapping
    @ExecutionTime
    public void save(@RequestBody UserToSaveDTO userDTO){
        userService.save(userDTO);
    }

    @DeleteMapping("/{id}")
    @ExecutionTime
    public void delete(@PathVariable int id){
        userService.delete(id);
    }

    @PutMapping("/{id}")
    @ExecutionTime
    public void update(@PathVariable int id, @RequestBody UserDTO userDTO){
        userService.update(id, userDTO);
    }

    @GetMapping("/{id}")
    @ExecutionTime
    public UserDTO getById(@PathVariable int id){
        return userService.getById(id);
    }

}
