package com.example.springsecuritybackend.repository;

import com.example.springsecuritybackend.domain.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Integer> {

}
