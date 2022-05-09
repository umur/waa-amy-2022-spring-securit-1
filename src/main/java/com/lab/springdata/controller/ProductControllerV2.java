package com.lab.springdata.controller;

import com.lab.springdata.entity.Product;
import com.lab.springdata.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/product")
public class ProductControllerV2 {
    private ProductService productService;

    public ProductControllerV2(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{price}")
    public List<Product> getByMinPrice(@PathVariable String price){
        return  productService.getByMinPrice(Double.parseDouble(price));
    }
    @GetMapping("/{cat}/{price}")
    public List<Product> getByCatAndMaxPrice(@PathVariable String cat, @PathVariable String price){
        return  productService.getByCatAndMaxPrice(cat,Double.parseDouble(price) );
    }
    @GetMapping("/search/{keyword}")
    public List<Product> getByKeyword(@PathVariable String keyword){
        return  productService.getByNameHas(keyword);
    }
    @GetMapping("/creator/{id}")
    public List<Product> getByCreatorId(@PathVariable int id){
        return  productService.getByCreatorId(id);
    }
}
