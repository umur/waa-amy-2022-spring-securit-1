package com.shop.association.controller;

import com.shop.association.domain.Product;
import com.shop.association.domain.bidirection.joincolumn.User3;
import com.shop.association.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("api/v1/products")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public void save(@RequestBody Product product, HttpServletRequest httpServletRequest) {
        var user = httpServletRequest.getUserPrincipal().getName();
//        System.out.println("==================");
//        System.out.println(user);
        productService.save(product, user);
    }
    @PutMapping("/{id}")
    public void update(@RequestBody Product product,@PathVariable int id) {
        productService.update(product, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        productService.delete(id);
    }

    @GetMapping
    public List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable int id) {
        return productService.getById(id);
    }

    @GetMapping("filter-product-price-more-than")
    public List<Product> priceMoreThanMinPrice(@RequestParam("min-price") double minPrice){
        return productService.priceMoreThanMinPrice(minPrice);
    }

    @GetMapping("filter-product-in-cat-price-more-than")
    public List<Product> productInCatPriceLessThanMaxPrice(@RequestParam("category") String category, @RequestParam("max-price") double maxPrice){
        System.out.println(category);
        System.out.println(maxPrice);
        return productService.productInCatPriceLessThanMaxPrice(category, maxPrice);
    }

}
