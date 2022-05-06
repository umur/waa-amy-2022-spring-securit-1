package com.shop.association.domain.unidirectional.joincolumn;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "addresses1")
public class Address1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String street;
    private String zip;
    private String city;
}
