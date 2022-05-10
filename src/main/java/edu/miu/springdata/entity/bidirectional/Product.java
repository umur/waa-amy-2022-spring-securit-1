package edu.miu.springdata.entity.bidirectional;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;
    private Double rating;

    @ManyToOne
    @JoinColumn
    private Category categoryName;

}
