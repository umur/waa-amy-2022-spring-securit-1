package com.security.waa.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String email;
    private String password;
    private String firstname;
    private String lastname;

    @JoinTable
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> role;
}
