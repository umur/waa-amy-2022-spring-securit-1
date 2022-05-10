package edu.miu.springdata.service.impl;

import edu.miu.springdata.dto.ReviewDto;
import edu.miu.springdata.entity.bidirectional.joincolumn.Review;
import edu.miu.springdata.repository.ReviewRepository;
import edu.miu.springdata.service.ReviewService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository reviewRepository;
    private ModelMapper modelMapper;

    public ReviewServiceImpl(ReviewRepository reviewRepository,ModelMapper modelMapper){
        this.reviewRepository = reviewRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ReviewDto save(ReviewDto reviewDto) {
        var review = modelMapper.map(reviewDto, Review.class);
        return modelMapper.map(reviewRepository.save(review), ReviewDto.class);
    }

    @Override
    public List<ReviewDto> findAll() {
        var reviews = reviewRepository.findAll();
        Type listType = new TypeToken<List<ReviewDto>>(){}.getType();
        return modelMapper.map(reviews,listType);
    }

    @Override
    public ReviewDto findById(Long id) {
        var review = reviewRepository.findById(id);
        return modelMapper.map(review, ReviewDto.class);
    }

    @Override
    public void delete(Long id) {
        reviewRepository.deleteById(id);
    }

    @Override
    public List<ReviewDto> findAllReviewByProductId(Long id) {
        var reviews = reviewRepository.findAllByProductId(id);
        Type listType = new TypeToken<List<ReviewDto>>(){}.getType();
        return modelMapper.map(reviews,listType);
    }

}
