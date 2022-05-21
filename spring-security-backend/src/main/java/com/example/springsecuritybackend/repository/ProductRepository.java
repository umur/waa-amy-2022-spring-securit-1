package com.example.springsecuritybackend.repository;

import com.example.springsecuritybackend.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

    //    Find all products that contain keyword in the name.
    List<Product> findAllByNameEquals(String name);

    //    Find all products that cost more than minPrice.
    List<Product> findAllByPriceGreaterThan(double minPrice);

    //    Find all products in cat category and cost less than maxPrice.
    List<Product> findAllByCategory_NameAndPriceIsLessThan(String category, double price);


    //    Find all products created by the user with id =id.


    //    Find reviews of the product whose id is id.



}
