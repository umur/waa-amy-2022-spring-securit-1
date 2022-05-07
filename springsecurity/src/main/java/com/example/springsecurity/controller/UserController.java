package com.example.springsecurity.controller;

import com.example.springsecurity.entity.User;
import com.example.springsecurity.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("{id}")
    public Optional<User> getUserById(@PathVariable("id") int id) {
        return userService.getUserById(id);
    }

    @PostMapping()
    public void create(@RequestBody User user) {
        userService.create(user);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody User user, @PathVariable("id") int id) {
        userService.update(user, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        userService.delete(id);
    }
}
