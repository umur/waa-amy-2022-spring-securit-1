package com.example.springsecuritybackend.dto;

import com.example.springsecuritybackend.domain.Category;
import com.example.springsecuritybackend.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private int id;
    private String name;
    private double price;
    private int rating;
    private Category category;
    private User user;
}
