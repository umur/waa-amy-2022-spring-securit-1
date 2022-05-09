package com.lab.springdata.repo;

import com.lab.springdata.entity.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepo extends CrudRepository<Review, Integer> {
    @Override
    void deleteById(Integer integer);

    Review findById(int id);
    List<Review> findAll();
    <S extends Review> S save(S entity);
    <S extends Review> Iterable<S> saveAll(Iterable<S> entities);
    List<Review> findAllByProduct_Id(int id);
}
