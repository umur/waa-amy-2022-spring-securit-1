package com.lab.springdata.service.impl;

import com.lab.springdata.entity.Users;
import com.lab.springdata.repo.UsersRepo;
import com.lab.springdata.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {
    private final UsersRepo usersRepo;
    public void save(Users u) {
        Users user=new Users();
        user.setFirstName(u.getFirstName());
        user.setLastName(u.getLastName());
        user.setAddress(u.getAddress());
        user.setEmail(u.getEmail());
        user.setPassword(u.getPassword());
        user.setReviews(u.getReviews());
        usersRepo.save(user);
    }
    public void saveAll(List<Users> listUsers) {
        usersRepo.saveAll(listUsers);
    }
    public void deleteById(int id){
        usersRepo.deleteById(id);
    }
    public List<Users> getAll(){
        return usersRepo.findAll();
    }
    public Users getById(int id){
        return usersRepo.findById(id);
    }
}
