package com.pprajapati.springsecurity.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "products")
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "product_name")
  private String productName;
  private float price;

  @JsonManagedReference
  @OneToOne
  @JoinColumn(name = "user_id")
  private User user;
}
