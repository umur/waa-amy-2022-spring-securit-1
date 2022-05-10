package edu.miu.springdata.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private Long id;
    private String name;
    private double price;
    private Double rating;
    private CategoryDto category;

}
