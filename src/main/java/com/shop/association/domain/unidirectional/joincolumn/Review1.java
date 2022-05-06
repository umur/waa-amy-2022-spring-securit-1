package com.shop.association.domain.unidirectional.joincolumn;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "reviews1")
@Entity
public class Review1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String comment;
}
