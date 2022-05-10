package edu.miu.springdata.entity.unidirectional;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class CategoryB {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany
//    @JoinColumn(name = "id_category")
    private List<ProductB> products;



}
