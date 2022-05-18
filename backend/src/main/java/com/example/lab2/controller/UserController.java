package com.example.lab2.controller;

import com.example.lab2.aspect.annotation.ExecutionTime;
import com.example.lab2.dto.User.UserDTO;
import com.example.lab2.dto.User.UserSaveDTO;
import com.example.lab2.service.UserService;
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
    public void save(@RequestBody UserSaveDTO userDTO){
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
