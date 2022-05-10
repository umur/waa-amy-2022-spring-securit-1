package edu.miu.springdata.entity.bidirectional.joincolumn;

import edu.miu.springdata.entity.bidirectional.Product;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comment;

    @ManyToOne
    @JoinColumn
    private User user;

    @ManyToOne
    private Product product;


}
