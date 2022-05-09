package com.lab.springdata.service.impl;

import com.lab.springdata.entity.Address;
import com.lab.springdata.repo.AddressRepo;
import com.lab.springdata.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepo addressRepo;

    public void save(Address adr){
        addressRepo.save(adr);
    }
    public void saveAll(List<Address> listAddr){
        addressRepo.saveAll(listAddr);
    }
    public void deleteById(int id){
        addressRepo.deleteById(id);
    }
    public Address getById(int id){
        return addressRepo.findById(id);
    }
    public List<Address> getAll(){
        return addressRepo.findAll();
    }

}
