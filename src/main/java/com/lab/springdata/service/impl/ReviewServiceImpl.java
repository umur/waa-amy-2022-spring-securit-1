package com.lab.springdata.service.impl;

import com.lab.springdata.entity.Review;
import com.lab.springdata.repo.ReviewRepo;
import com.lab.springdata.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepo reviewRepo;

    public void save(Review rw){
        reviewRepo.save(rw);
    }
    public void saveAll(List<Review> listRw){
        reviewRepo.saveAll(listRw);
    }
    public void deleteById(int id){
        reviewRepo.deleteById(id);
    }
    public Review getById(int id){
        return reviewRepo.findById(id);
    }
    public List<Review> getAll(){
        return reviewRepo.findAll();
    }
    public List<Review> getByProductId(int id){
        return reviewRepo.findAllByProduct_Id(id);
    }
}
