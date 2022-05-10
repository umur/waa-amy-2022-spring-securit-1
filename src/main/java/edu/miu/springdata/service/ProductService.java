package edu.miu.springdata.service;

import edu.miu.springdata.dto.ProductDto;

import java.util.List;

public interface ProductService {

    ProductDto save(ProductDto product);

    List<ProductDto> findAll();

    ProductDto findById(Long id);

    void deleteById(Long id);

    List<ProductDto> findAllByPriceGreaterThan(Double minPrice);

    List<ProductDto> findByCategoryNameAndPriceLessThan(String categoryName, Double maxPrice);

    List<ProductDto> findAllByNameContains(String keyword);

}
