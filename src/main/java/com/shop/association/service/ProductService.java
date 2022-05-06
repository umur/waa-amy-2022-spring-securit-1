package com.shop.association.service;

import com.shop.association.domain.Product;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ProductService {
    void save(Product product, String email);

    void update(Product product, int id);

    void delete(int id);

    List<Product> getAll();

    Product getById(int id);

    List<Product> priceMoreThanMinPrice(double minPrice);

    List<Product> productInCatPriceLessThanMaxPrice(String categoryName, double maxPrice);
}
