package com.shop.association.domain.unidirectional.joincolumn;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Table(name = "users1")
@Entity
public class User1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String password;
    private String firstName;
    private String lastname;
    @OneToOne
    private Address1 address;
    @OneToMany
    @JoinColumn(name = "user1_id")
    private List<Review1> reviews;
}
