package com.lab.springdata.controller;

import com.lab.springdata.entity.Review;
import com.lab.springdata.service.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/review")
public class ReviewController {
    private ReviewService reviewService;
    public ReviewController(ReviewService reviewService){
        this.reviewService=reviewService;
    }
    @GetMapping
    public List<Review> getAll(){
        return reviewService.getAll();
    }
    @GetMapping("/{id}")
    public Review getById(@PathVariable int id){
        return  reviewService.getById(id);
    }
    @GetMapping("creator/{id}")
    public List<Review> getByProductId(@PathVariable int id){
        return  reviewService.getByProductId(id);
    }
    @PostMapping
    public void save(@RequestBody Review u){
        reviewService.save(u);
    }
    @PostMapping(params = "save=all")
    public void saveAll(@RequestBody List<Review> ul){
        reviewService.saveAll(ul);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        reviewService.deleteById(id);
    }
}
