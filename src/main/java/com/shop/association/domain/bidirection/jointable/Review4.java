package com.shop.association.domain.bidirection.jointable;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "reviews4")
@Entity
public class Review4 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String comment;
    @ManyToOne
    private User4 user4;
}
