package com.pprajapati.springsecurity.repo;


import com.pprajapati.springsecurity.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {
  User findByUserName(String userName);
}
