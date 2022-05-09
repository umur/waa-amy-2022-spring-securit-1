package com.lab.springdata.repo;

import com.lab.springdata.entity.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepo extends CrudRepository<Users, Integer> {
    @Override
    void deleteById(Integer integer);

    Users findById(int id);
    List<Users> findAll();
    <S extends Users> S save(S entity);
    <S extends Users> Iterable<S> saveAll(Iterable<S> entities);
    Users findByEmail(String email);

}
