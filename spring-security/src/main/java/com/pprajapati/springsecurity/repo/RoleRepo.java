package com.pprajapati.springsecurity.repo;

import com.pprajapati.springsecurity.domain.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends CrudRepository<Role, Integer> {
}
