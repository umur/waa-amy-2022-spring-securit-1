package com.pprajapati.springsecurity.service.impl;

import com.pprajapati.springsecurity.domain.Product;
import com.pprajapati.springsecurity.repo.ProductRepo;
import com.pprajapati.springsecurity.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
  private final ProductRepo productRepo;

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
