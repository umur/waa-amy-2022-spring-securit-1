package assignment.lab4.controller;

import assignment.lab4.aspect.annotation.ExecutionTime;
import assignment.lab4.entity.Product;
import assignment.lab4.entity.Review;
import assignment.lab4.entity.User;
import assignment.lab4.service.ProductService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/products")
@RestController
//@CrossOrigin
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //@ExecutionTime
    @PostMapping
    public void save(@RequestBody Product p) {
        System.out.println("posttt");
        productService.save(p);
    }


@ExecutionTime
    @GetMapping
    public List<Product> getAll() {

        return productService.getAll();
    }
    @ExecutionTime
    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable int id) {
        var product = productService.getById(id);
        return ResponseEntity.ok(product);
    }

    @ExecutionTime
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        productService.delete(id);
    }
    @ExecutionTime
    @PutMapping("/{id}")
    public void update(@PathVariable("id") int productId) {
        //call service
    }

    @GetMapping("/{id}/reviews")
    public ResponseEntity<Review> getReviewsByProductId(@PathVariable int id) {
        // for demo purposes, this request is not authorized.
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
    }
}
