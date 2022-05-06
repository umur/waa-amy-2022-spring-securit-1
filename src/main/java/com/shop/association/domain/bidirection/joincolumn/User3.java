package com.shop.association.domain.bidirection.joincolumn;

import com.shop.association.domain.Product;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Table(name = "users3")
@Entity
public class User3 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String password;
    private String firstName;
    private String lastname;
    private String role;
    @OneToOne
    private Address3 address;

    @OneToMany(mappedBy = "user3")
    private List<Review3> reviews;

}
