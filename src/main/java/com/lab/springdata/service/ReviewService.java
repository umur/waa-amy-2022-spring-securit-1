package com.lab.springdata.service;

import com.lab.springdata.entity.Review;
import com.lab.springdata.repo.ReviewRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ReviewService {

    public void save(Review rw);

    public void saveAll(List<Review> listRw);
    public void deleteById(int id);
    public Review getById(int id);
    public List<Review> getAll();
    public List<Review> getByProductId(int id);
}
