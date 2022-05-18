package com.example.lab2.repository;

import com.example.lab2.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {
//    Category findFirstBy(String name);
}
