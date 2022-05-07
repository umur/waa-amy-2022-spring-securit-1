package com.example.springsecurity.controller;


import com.example.springsecurity.entity.Review;
import com.example.springsecurity.service.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    ReviewService reviewService;
    @GetMapping()
    public List<Review> getReviews() {
        return reviewService.getAll();
    }
    @PostMapping()
    public void createReview(@RequestBody Review review) {
        reviewService.create(review);
    }

    @PutMapping("/{id}")
    public void updateReview(@RequestBody Review review, @PathVariable("id") int id) {
        reviewService.update(review, id);
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable("id") int id) {
        reviewService.delete(id);
    }

}
