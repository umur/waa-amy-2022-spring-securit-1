package com.shop.association.repository;

import com.shop.association.domain.bidirection.joincolumn.Review3;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Review3Repo extends CrudRepository<Review3, Integer> {
}
