package com.example.springsecuritybackend.repository;

import com.example.springsecuritybackend.domain.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {
//    Category findFirstBy(String name);
}
