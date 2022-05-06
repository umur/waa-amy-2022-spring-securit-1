package com.shop.association.domain.bidirection.jointable;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "addresses4")
@Entity
public class Address4 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String street;
    private String zip;
    private String city;
    @OneToOne
    private User4 user4;
}