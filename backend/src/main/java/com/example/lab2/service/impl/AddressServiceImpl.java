package com.example.lab2.service.impl;

import com.example.lab2.dto.AddressDTO;
import com.example.lab2.entity.Address;
import com.example.lab2.repository.AddressRepository;
import com.example.lab2.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final ModelMapper modelMapper;

    @Override
    public void save(AddressDTO addressDTO) {
        addressRepository.save(modelMapper.map(addressDTO, Address.class));
    }

    @Override
    public void delete(int id) {
        addressRepository.deleteById(id);
    }

    @Override
    public void update(int id, AddressDTO addressDTO) {
        var address = addressRepository.findById(id);
        if (address.isPresent()){
            address.get().setStreet(addressDTO.getStreet());
            address.get().setZip(addressDTO.getZip());
            address.get().setUser(addressDTO.getUser());
            addressRepository.save(address.get());
        }
    }

    @Override
    public AddressDTO getById(int id) {
        var a = addressRepository.findById(id);
        return a.isPresent() ? modelMapper.map(a.get(), AddressDTO.class): null;
    }

    @Override
    public List<AddressDTO> getAll() {
        return StreamSupport
                .stream(addressRepository.findAll().spliterator(), false)
                .map(u -> modelMapper.map(u, AddressDTO.class))
                .collect(Collectors.toList());
    }
}
