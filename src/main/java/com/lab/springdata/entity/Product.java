package com.lab.springdata.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private double price;
    private double raiting;
    private int user_id;

    // for bi direction
    @ManyToOne
    private Category category;
    @ManyToOne
    //@JoinColumn(name="creator_user_id")
    private Users creator;



}
