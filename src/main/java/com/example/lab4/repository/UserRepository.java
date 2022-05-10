package com.example.lab4.repository;

import com.example.lab4.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
    public User findByEmail(String email);
}
