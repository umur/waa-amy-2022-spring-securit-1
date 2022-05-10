package edu.miu.springdata.entity.bidirectional.jointable;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Review1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comment;

    @ManyToOne
    private User1 user1;


}
