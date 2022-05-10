package edu.miu.springdata.entity.unidirectional.jointable;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class User4 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String eMail;
    private String password;
    private String firsName;
    private String lastName;

    @OneToMany
    private List<Review4> reviews;

    @OneToOne
    @JoinColumn(name = "id_address")
    private Address4 address4;


}
