package com.lab.springdata.repo;

import com.lab.springdata.entity.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepo extends CrudRepository<Address,Integer> {
    @Override
    void deleteById(Integer integer);

    Address findById(int id);
    List<Address> findAll();
    <S extends Address> S save(S entity);
    <S extends Address> Iterable<S> saveAll(Iterable<S> entities);
}
