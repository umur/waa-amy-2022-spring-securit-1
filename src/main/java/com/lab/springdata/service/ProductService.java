package com.lab.springdata.service;

import com.lab.springdata.entity.Product;
import com.lab.springdata.repo.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {

    public void save(Product p);

    public void saveAll(List<Product> listProduct);

    public void deleteById(int id);

    public Product getById(int id);

    public List<Product> getAll();

    public List<Product> getByMinPrice(double minPrice);

    public List<Product> getByCatAndMaxPrice(String cat, double maxPrice);

    public List<Product> getByNameHas(String keyword);

    public List<Product> getByCreatorId(int id);

}
