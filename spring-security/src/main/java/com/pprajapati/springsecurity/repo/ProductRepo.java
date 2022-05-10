package com.pprajapati.springsecurity.repo;

import com.pprajapati.springsecurity.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends CrudRepository<Product, Integer> {
}
