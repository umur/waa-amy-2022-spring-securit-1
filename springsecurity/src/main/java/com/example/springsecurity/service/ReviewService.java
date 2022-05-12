package com.example.springsecurity.service;

import com.example.springsecurity.entity.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getAll();

    void create(Review review);

    void update(Review review, int id);

    void delete(int id);
}
