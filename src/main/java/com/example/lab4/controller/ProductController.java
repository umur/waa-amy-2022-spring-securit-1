package com.example.lab4.controller;

import com.example.lab4.aspect.annotation.OffensiveWarn;
import com.example.lab4.entity.Product;
import com.example.lab4.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/products")
@CrossOrigin
public class ProductController {
    private final ProductService productService;
    public ProductController(ProductService productService){
        this.productService = productService;
    }
    @OffensiveWarn
    @PostMapping
    public ResponseEntity<String> save(@RequestBody Product p){
        productService.save(p);
        return ResponseEntity.ok("Success");
    }
    @GetMapping
    public ResponseEntity<Iterable<Product>> getAll(){
            Iterable<Product> list = productService.getAll();
            return ResponseEntity.ok(list);

    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getByID(@PathVariable int id){
        Product p = productService.getById(id);
        return ResponseEntity.ok(p);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> update(@RequestBody Product p ,@PathVariable int id){
        productService.update(p,id);
        return ResponseEntity.ok("Success");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        productService.delete(id);
        return ResponseEntity.ok("Success");
    }
}
