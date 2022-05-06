package com.shop.association.domain.unidirectional.jointable;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "reviews2")
public class Review2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String comment;
}
