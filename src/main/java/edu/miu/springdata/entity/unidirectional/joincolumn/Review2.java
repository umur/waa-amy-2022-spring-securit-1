package edu.miu.springdata.entity.unidirectional.joincolumn;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Review2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comment;

}
