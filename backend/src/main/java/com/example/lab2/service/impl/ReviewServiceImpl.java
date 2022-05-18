package com.example.lab2.service.impl;

import com.example.lab2.dto.ReviewDTO;
import com.example.lab2.entity.Review;
import com.example.lab2.repository.ReviewRepository;
import com.example.lab2.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final ModelMapper modelMapper;

    @Override
    public void save(ReviewDTO reviewDTO) {
        reviewRepository.save(modelMapper.map(reviewDTO, Review.class));
    }

    @Override
    public void delete(int id) {
        reviewRepository.deleteById(id);
    }

    @Override
    public void update(int id, ReviewDTO reviewDTO) {
        var r = reviewRepository.findById(id);
        if (r.isPresent()){
            r.get().setComment(reviewDTO.getComment());
            r.get().setUser(reviewDTO.getUser());
            reviewRepository.save(r.get());
        }
    }

    @Override
    public List<ReviewDTO> getAll() {
        return StreamSupport.stream(reviewRepository.findAll().spliterator(), false)
                .map(r -> modelMapper.map(r, ReviewDTO.class))
                .toList();
    }

    @Override
    public ReviewDTO getById(int id) {
        var r = reviewRepository.findById(id);
        return r.isPresent() ? modelMapper.map(r.get(), ReviewDTO.class) : null;
    }
}
