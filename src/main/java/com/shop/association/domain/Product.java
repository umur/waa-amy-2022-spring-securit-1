package com.shop.association.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.shop.association.domain.bidirection.joincolumn.Review3;
import com.shop.association.domain.bidirection.joincolumn.User3;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private Double price;
    private Double rating;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Category category;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User3 user3;

    @OneToMany(mappedBy = "product")
    @JsonManagedReference
    private List<Review3> review3s;
}
