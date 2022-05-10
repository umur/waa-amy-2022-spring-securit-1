package edu.miu.springdata.service;

import edu.miu.springdata.dto.ReviewDto;

import java.util.List;

public interface ReviewService {

    ReviewDto save(ReviewDto review);

    List<ReviewDto> findAll();

    ReviewDto findById(Long id);

    void delete(Long id);

    List<ReviewDto> findAllReviewByProductId(Long id);
}
