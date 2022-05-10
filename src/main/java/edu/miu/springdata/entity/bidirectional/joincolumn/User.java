package edu.miu.springdata.entity.bidirectional.joincolumn;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String eMail;
    private String password;
    private String firsName;
    private String lastName;

    @OneToMany(mappedBy = "user")
    private List<Review> reviews;

    @OneToOne
    @JoinColumn(name = "id_address")
    private Address address;


}
