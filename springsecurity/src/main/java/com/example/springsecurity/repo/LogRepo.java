package com.example.springsecurity.repo;

import com.example.springsecurity.entity.Activity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepo extends CrudRepository<Activity, Integer> {
}
