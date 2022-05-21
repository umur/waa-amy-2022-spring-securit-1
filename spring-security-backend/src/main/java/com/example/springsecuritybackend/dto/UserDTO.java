package com.example.springsecuritybackend.dto;

import com.example.springsecuritybackend.domain.Address;
import com.example.springsecuritybackend.domain.Product;
import com.example.springsecuritybackend.domain.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private int id;
    private String email;
    private String password;
    private String firstname;
    private String lastname;
    private List<Review> reviewList;
    private Address address;
    private List<Product> productList;
    public UserDTO(int id, String email, String password, String firstname, String lastname) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
    }
}
