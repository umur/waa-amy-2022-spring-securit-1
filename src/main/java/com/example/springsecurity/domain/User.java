package com.example.springsecurity.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String role;

    @OneToMany(mappedBy = "user")
    private List<Review> reviews;

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    private Address address;
}
