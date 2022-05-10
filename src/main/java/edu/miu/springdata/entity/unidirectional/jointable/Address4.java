package edu.miu.springdata.entity.unidirectional.jointable;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Address4 {
    @Id
    private Long id;

    private String street;
    private String zip;
    private String city;




}
