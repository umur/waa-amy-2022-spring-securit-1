package com.lab.springdata.service;

import com.lab.springdata.entity.Users;
import com.lab.springdata.repo.UsersRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UsersService {
    public void save(Users u);
    public void saveAll(List<Users> listUsers);
    public void deleteById(int id);
    public List<Users> getAll();
    public Users getById(int id);
}
