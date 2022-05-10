package edu.miu.springdata.repository;

import edu.miu.springdata.entity.bidirectional.joincolumn.Review;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReviewRepository extends CrudRepository<Review, Long> {

    List<Review> findAllByProductId(Long id);
}
