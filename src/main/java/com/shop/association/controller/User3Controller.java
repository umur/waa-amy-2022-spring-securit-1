package com.shop.association.controller;

import com.shop.association.domain.bidirection.joincolumn.User3;
import com.shop.association.service.User3Service;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users3")
@AllArgsConstructor
public class User3Controller {
    private final User3Service user3Service;

    @PatchMapping
    public void save(@RequestBody User3 user3) {
        user3Service.save(user3);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody User3 user3, @PathVariable int id) {
        user3Service.update(user3, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        user3Service.delete(id);
    }

    @GetMapping
    public List<User3> getAll() {
        return  user3Service.getAll();
    }

    @GetMapping("/{id}")
    public User3 getById(@PathVariable int id) {
        return user3Service.getById(id);
    }

}
