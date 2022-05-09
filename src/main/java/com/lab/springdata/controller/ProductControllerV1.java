package com.lab.springdata.controller;

import com.lab.springdata.entity.Product;
import com.lab.springdata.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductControllerV1 {
    private ProductService productService;

    public ProductControllerV1(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAll(){
        return productService.getAll();
    }
    @GetMapping("/{id}")
    public Product getById(@PathVariable int id){
        return  productService.getById(id);
    }
    @PostMapping
    public void save(@RequestBody Product p, @RequestHeader("Authorization") String ah){

        productService.save(p);
    }
    @PostMapping(params = "save=all")
    public void saveAll(@RequestBody List<Product> pl){
        productService.saveAll(pl);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        productService.deleteById(id);
    }
}
