package com.shop.association.domain.bidirection.jointable;

import com.shop.association.domain.bidirection.joincolumn.Address3;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Table(name = "users4")
@Entity
public class User4 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String password;
    private String firstName;
    private String lastname;
    @OneToOne
    private Address3 address;
    @OneToMany
    private List<Review4> reviews;
}
