package com.shop.association.domain.bidirection.joincolumn;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "addresses3")
@Entity
public class Address3 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String street;
    private String zip;
    private String city;
    @OneToOne
    private User3 user3;
}
