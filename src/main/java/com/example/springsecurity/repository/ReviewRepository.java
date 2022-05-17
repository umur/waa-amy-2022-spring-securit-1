package com.example.springsecurity.repository;

import com.example.springsecurity.domain.Review;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReviewRepository extends CrudRepository<Review, Long> {

    List<Review> findAllByProductId(Long id);
}
