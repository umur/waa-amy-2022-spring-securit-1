package com.example.lab4.service;

import com.example.lab4.entity.Product;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {
    public Iterable<Product> getAll();

    public Product getById(int id);

    public void update(Product p, int id);

    public void delete(int id);

    public void save(Product p);
}
