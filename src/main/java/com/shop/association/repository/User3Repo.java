package com.shop.association.repository;

import com.shop.association.domain.bidirection.joincolumn.User3;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface User3Repo extends CrudRepository<User3, Integer> {
    User3 findByEmail(String email);
}
