package com.example.springsecuritybackend.service;

import com.example.springsecuritybackend.dto.ReviewDTO;

import java.util.List;

public interface ReviewService {
    void save(ReviewDTO reviewDTO);
    void delete(int id);
    void update(int id, ReviewDTO reviewDTO);
    List<ReviewDTO> getAll();
    ReviewDTO getById(int id);
}
