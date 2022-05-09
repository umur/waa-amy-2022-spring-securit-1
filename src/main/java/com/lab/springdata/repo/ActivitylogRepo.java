package com.lab.springdata.repo;

import com.lab.springdata.entity.Activitylog;
import com.lab.springdata.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivitylogRepo extends CrudRepository<Activitylog,Integer> {

    @Override
    List<Activitylog> findAll();

    Activitylog save(Activitylog entity);
}
