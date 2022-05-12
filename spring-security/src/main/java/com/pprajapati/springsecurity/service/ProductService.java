package com.pprajapati.springsecurity.service;

import com.pprajapati.springsecurity.domain.Product;
import com.pprajapati.springsecurity.dto.ProductDtoResponse;
import org.springframework.context.annotation.Profile;

import java.util.List;

public interface ProductService {
  void save(Product p);
  void delete(int id);
  Product getById(int id);
  List<ProductDtoResponse> getAll();
}
