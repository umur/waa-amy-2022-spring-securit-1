package edu.miu.springdata.entity.unidirectional.joincolumn;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@Entity
public class Address2 {
    @Id
    private Long id;

    private String street;
    private String zip;
    private String city;




}
