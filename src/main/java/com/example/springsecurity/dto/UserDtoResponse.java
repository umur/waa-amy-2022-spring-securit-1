package com.example.springsecurity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDtoResponse {
    private Long id;

    private String firstName;
    private String lastName;
    private String role;

    private String email;

    private List<ReviewDto> reviews;
    private AddressDto address;
}
