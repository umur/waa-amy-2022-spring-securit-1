package com.lab.springdata.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int zip;
    private String street;
    private String city;
    /*
    @OneToOne(mappedBy = "address")// for bi directional
    private Users user;
     */

}
/*
Address with id, street, zip and city.
An Address can belong to only one User.
 */