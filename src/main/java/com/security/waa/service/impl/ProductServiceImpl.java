package com.security.waa.service.impl;

import com.security.waa.entity.Product;
import com.security.waa.repository.ProductRepo;
import com.security.waa.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepo productRepo;

    @Override
    public void save(Product p) {
        productRepo.save(p);
    }

    @Override
    public void delete(int id) {
        productRepo.deleteById(id);
    }

    @Override
    public Product getById(int id) {
        return productRepo.findById(id).get();
    }

    @Override
    public List<Product> getAll() {
        var result = new ArrayList<Product>();
        productRepo.findAll().forEach(result::add);
        return result;
    }
}
