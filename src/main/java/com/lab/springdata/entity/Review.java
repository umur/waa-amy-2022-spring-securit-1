package com.lab.springdata.entity;

import lombok.Data;
import java.util.*;

import javax.persistence.*;

@Entity
@Data
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String comment;

    //bi directional join column
    @ManyToOne
    //@JoinColumn(name="user_id")
    private Users user;//no user if uni-direction
    @ManyToOne
    //@JoinColumn(name="product_id")
    private Product product;

}

/*
Review with id, comment.
A Review can only belong to one User.
 */