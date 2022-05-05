package com.security.waa.service;

import com.security.waa.entity.Product;

import java.util.List;

public interface ProductService {
    void save(Product p);

    void delete(int id);

    Product getById(int id);

    List<Product> getAll();
}
