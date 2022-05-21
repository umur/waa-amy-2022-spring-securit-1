package com.example.springsecuritybackend.controller;

import com.example.springsecuritybackend.aspect.annotation.ExecutionTime;
import com.example.springsecuritybackend.dto.ProductDTO;
import com.example.springsecuritybackend.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
@CrossOrigin
public class ProductController {

    private final ProductService productService;

    @GetMapping
    @ExecutionTime
    public List<ProductDTO> getAll(){
        return productService.getAll();
    }

    @GetMapping("/{id}")
    @ExecutionTime
    public ProductDTO getById(@PathVariable int id){
        return productService.getById(id);
    }

    //consumes = {"application/json"}
    @PostMapping
    @ExecutionTime
    public void save(@RequestBody ProductDTO productDTO){
        productService.save(productDTO);
    }

    @DeleteMapping("/{id}")
    @ExecutionTime
    public void delete(@PathVariable int id){
        productService.delete(id);
    }

    @PutMapping("/{id}")
    @ExecutionTime
    public void update(@PathVariable int id, @RequestBody ProductDTO productDTO){
        productService.update(id, productDTO);
    }

    @GetMapping("/find-all-by-name")
    @ExecutionTime
    public List<ProductDTO> findAllByNameEquals(@RequestParam String name){
        return productService.findAllByNameEquals(name);
    }

    @GetMapping("/find-all-by-price")
    @ExecutionTime
    public List<ProductDTO> findAllByPriceGreaterThan(@RequestParam double price){
        return productService.findAllByPriceGreaterThan(price);
    }

    @GetMapping("/find-all-by-category-and-price")
    @ExecutionTime
    public List<ProductDTO> findAllByCategoryAndPriceIsLessThan(@RequestParam String category, @RequestParam double price){
        return productService.findAllByCategoryAndPriceIsLessThan(category, price);
    }
}
