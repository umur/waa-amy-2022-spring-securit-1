package com.example.lab4.service.impl;

import com.example.lab4.entity.Product;
import com.example.lab4.repository.ProductRepository;
import com.example.lab4.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    @Override
    public Iterable<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getById(int id) {
        Optional<Product> result = productRepository.findById(id);
        if(result.isPresent()){
            return result.get();
        }else{
            return null;
        }
    }

    @Override
    public void update(Product p, int id) {
        Product product = productRepository.findById(id).get();
        product.setName(p.getName());
        product.setId(p.getId());
        product.setPrice(p.getPrice());
        productRepository.save(product);
    }

    @Override
    public void delete(int id) {
        Product product = productRepository.findById(id).get();
        productRepository.delete(product);
    }

    @Override
    public void save(Product p) {
        productRepository.save(p);
    }
}
