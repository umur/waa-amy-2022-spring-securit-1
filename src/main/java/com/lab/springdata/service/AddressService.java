package com.lab.springdata.service;

import com.lab.springdata.entity.Address;
import com.lab.springdata.repo.AddressRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AddressService {


    public void save(Address adr);
    public void saveAll(List<Address> listAddr);
    public void deleteById(int id);
    public Address getById(int id);
    public List<Address> getAll();

}
