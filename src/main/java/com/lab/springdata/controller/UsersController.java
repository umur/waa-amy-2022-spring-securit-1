package com.lab.springdata.controller;

import com.lab.springdata.aspect.annotation.GetInfo;
import com.lab.springdata.entity.Users;
import com.lab.springdata.service.UsersService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {
    private UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping
    @GetInfo
    public List<Users> getAll(){
        return usersService.getAll();
    }
    @GetMapping("/{id}")
    public Users getById(@PathVariable int id){
        return  usersService.getById(id);
    }
    @PostMapping
    public void save(@RequestBody Users u){
        usersService.save(u);
    }
    @PostMapping(params = "save=all")
    public void saveAll(@RequestBody List<Users> ul){
        usersService.saveAll(ul);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        usersService.deleteById(id);
    }

}
