package com.lab.springdata.controller;

import com.lab.springdata.entity.Address;
import com.lab.springdata.service.AddressService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    private AddressService addressService;

    public AddressController(AddressService addressService){
        this.addressService=addressService;
    }
    @GetMapping
    public List<Address> getAll(){
        return addressService.getAll();
    }
    @GetMapping("/{id}")
    public Address getById(@PathVariable int id){
        return  addressService.getById(id);
    }
    @PostMapping
    public void save(@RequestBody Address u){
        addressService.save(u);
    }
    @PostMapping(params = "save=all")
    public void saveAll(@RequestBody List<Address> ul){
        addressService.saveAll(ul);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        addressService.deleteById(id);
    }
}
