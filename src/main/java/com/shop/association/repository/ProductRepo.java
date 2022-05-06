package com.shop.association.repository;

import com.shop.association.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends CrudRepository<Product, Integer> {
    List<Product> findAllByPriceGreaterThan(double minPrice);

    List<Product> findAllByCategoryNameAndPriceLessThan(String categoryName, double maxPrice);
}
