package com.example.springsecurity.repo;

import com.example.springsecurity.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends CrudRepository<Product, Integer> {
    List<Product> findAllByNameContaining(String name);
    List<Product> findAllByPriceGreaterThan(float price);
    List<Product> findAllByPriceLessThan(float price);
}
