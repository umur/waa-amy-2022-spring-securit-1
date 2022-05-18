package com.example.lab2.dto;

import com.example.lab2.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {
    private int id;
    private String street;
    private String zip;
    private User user;
}

