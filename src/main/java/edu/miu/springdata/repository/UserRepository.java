package edu.miu.springdata.repository;

import edu.miu.springdata.entity.unidirectional.joincolumn.User3;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User3, Long> {
    User3 findByEmail(String email);
}
