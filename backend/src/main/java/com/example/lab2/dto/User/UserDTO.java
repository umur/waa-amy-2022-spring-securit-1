package com.example.lab2.dto.User;

import com.example.lab2.entity.Address;
import com.example.lab2.entity.Product;
import com.example.lab2.entity.Review;
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
