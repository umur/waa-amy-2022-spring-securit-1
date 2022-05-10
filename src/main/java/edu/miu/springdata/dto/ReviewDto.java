package edu.miu.springdata.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDto {

    private Long id;
    private String comment;

}
