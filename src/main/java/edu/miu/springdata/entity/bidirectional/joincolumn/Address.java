package edu.miu.springdata.entity.bidirectional.joincolumn;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.List;

@Data
@Entity
public class Address {
    @Id
    private Long id;

    private String street;
    private String zip;
    private String city;

    @OneToOne(mappedBy = "address")
    private User user;



}
