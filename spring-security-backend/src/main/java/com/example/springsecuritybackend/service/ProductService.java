package com.example.springsecuritybackend.service;

import com.example.springsecuritybackend.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    void save(ProductDTO productDTO);
    void delete(int id);
    void update(int id, ProductDTO productDTO);
    ProductDTO getById(int id);
    List<ProductDTO> getAll();
    List<ProductDTO> findAllByNameEquals(String name);
    List<ProductDTO> findAllByPriceGreaterThan(double minPrice);
    List<ProductDTO> findAllByCategoryAndPriceIsLessThan(String category, double price);
}
