package com.security.waa.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Product {
    @Id
    @SequenceGenerator(name = "samples_id_seq", sequenceName = "samples_id_seq", initialValue = 10, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "samples_id_seq")
    private int id;

    private String name;
    private float price;


}
