package com.example.springsecuritybackend.controller;

import com.example.springsecuritybackend.aspect.annotation.ExecutionTime;
import com.example.springsecuritybackend.dto.ReviewDTO;
import com.example.springsecuritybackend.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping
    @ExecutionTime
    public List<ReviewDTO> getAll(){
        return reviewService.getAll();
    }

    @GetMapping("/{id}")
    @ExecutionTime
    public ReviewDTO getById(@PathVariable int id){
        return reviewService.getById(id);
    }

    @PostMapping
    @ExecutionTime
    public void save(@RequestBody ReviewDTO reviewDTO){
        reviewService.save(reviewDTO);
    }

    @DeleteMapping
    @ExecutionTime
    public void delete(@PathVariable int id){
        reviewService.delete(id);
    }

    @PutMapping("/{id}")
    @ExecutionTime
    public void update(@PathVariable int id, @RequestBody ReviewDTO reviewDTO){
        reviewService.update(id, reviewDTO);
    }
}
