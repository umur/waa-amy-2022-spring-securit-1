package com.shop.association.domain.unidirectional.jointable;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Table(name = "users2")
@Entity
public class User2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String password;
    private String firstName;
    private String lastname;
    @OneToOne
    private Address2 address;
    @OneToMany
    private List<Review2> reviews;
}
