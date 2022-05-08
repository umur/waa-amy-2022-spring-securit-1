package com.security.waa.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @SequenceGenerator(name = "samples_id_seq", sequenceName = "samples_id_seq", initialValue = 10, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "samples_id_seq")
    private int id;

    private String email;

    @JsonIgnore
    private String password;

    private String firstname;
    private String lastname;

    @JoinTable
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> role;

    @JsonBackReference
    @OneToOne(mappedBy = "user")
    private Product product;
}
