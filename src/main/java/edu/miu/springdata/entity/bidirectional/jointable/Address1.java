package edu.miu.springdata.entity.bidirectional.jointable;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@Entity
public class Address1 {
    @Id
    private Long id;

    private String street;
    private String zip;
    private String city;

    @OneToOne(mappedBy = "address1")
    private User1 user1;



}
