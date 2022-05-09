package com.lab.springdata.entity;

import lombok.Data;
import java.util.*;

import javax.persistence.*;

@Entity
@Data
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    //@OneToMany join table by default
    @OneToMany//(mappedBy = "user")
    //@JoinColumn(name = "user_id") // for join column
    private List<Review> reviews;


    @OneToOne
    //@JoinColumn(name = "address_id") //for join column
    // for bi direction go address class
    @JoinTable(name = "users_address", //for join table
            joinColumns =
                    { @JoinColumn(name = "users_id", referencedColumnName = "id") },
            inverseJoinColumns =
                    { @JoinColumn(name = "address_id", referencedColumnName = "id") })
    private Address address;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable
    private List<Role> roles;
}

/*
User with id, email, password, firstName, lastname.
User can create many Reviews.
User can have only one Address.
 */