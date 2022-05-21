package com.example.springsecuritybackend.dto;

import com.example.springsecuritybackend.domain.User;
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

