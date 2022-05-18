package com.example.lab2.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
//@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id")
    private int id;
    private String email;
    private String password;
    private String firstname;
    private String lastname;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @JsonBackReference
    private List<Review> reviewList;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
    @JsonManagedReference
    private Address address;

    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinTable
    private List<Role> roles;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference(value = "test2")
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Product> productList;

    public User(int id, String email, String password, String firstname, String lastname) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
    }
}
