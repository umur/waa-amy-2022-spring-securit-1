package com.lab.springdata.repo;

import com.lab.springdata.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepo extends CrudRepository<Category,Integer> {
    @Override
    void deleteById(Integer integer);

    Category findById(int id);
    List<Category> findAll();
    <S extends Category> S save(S entity);
    <S extends Category> Iterable<S> saveAll(Iterable<S> entities);


}
