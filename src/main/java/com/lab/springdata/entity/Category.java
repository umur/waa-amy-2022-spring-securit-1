package com.lab.springdata.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @OneToMany//join table by default
    @JoinColumn(name="category_id")//for join column
    private List<Product> products;
}
