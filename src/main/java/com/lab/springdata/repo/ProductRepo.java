package com.lab.springdata.repo;

import com.lab.springdata.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends CrudRepository<Product, Integer> {
    @Override
    void deleteById(Integer integer);

    Product findById(int id);

    List<Product> findAll();

    <S extends Product> S save(S entity);

    //List<Product> findTopByPriceAndCategory_NameEquals()

    <S extends Product> Iterable<S> saveAll(Iterable<S> entities);

    List<Product> findAllByPriceGreaterThan(double minPrice);

    List<Product> findAllByCategory_NameEqualsIgnoreCaseAndPriceLessThan(String cat, double maxPrice);

    List<Product> findAllByNameContainsIgnoreCase(String keyword);
    List<Product> findAllByCreator_Id(int id);
}

