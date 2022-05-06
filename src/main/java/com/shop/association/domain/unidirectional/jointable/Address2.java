package com.shop.association.domain.unidirectional.jointable;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "addresses2")
@Entity
public class Address2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String street;
    private String zip;
    private String city;
}
