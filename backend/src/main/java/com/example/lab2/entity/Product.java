package com.example.lab2.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double price;
    private int rating;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonBackReference(value = "test")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference(value = "test2")
    private User user;
}
