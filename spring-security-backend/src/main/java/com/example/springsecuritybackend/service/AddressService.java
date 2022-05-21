package com.example.springsecuritybackend.service;

import com.example.springsecuritybackend.dto.AddressDTO;

import java.util.List;

public interface AddressService {
    void save(AddressDTO addressDTO);
    void delete(int id);
    void update(int id, AddressDTO addressDTO);
    AddressDTO getById(int id);
    List<AddressDTO> getAll();
}
