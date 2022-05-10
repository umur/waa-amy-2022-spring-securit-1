package edu.miu.springdata.entity.unidirectional.joincolumn;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class User3 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;
    private String firsName;
    private String lastName;

    private String role;

    @OneToMany
    @JoinColumn(name = "id_user")
    private List<Review2> reviews;

    @OneToOne
    @JoinColumn(name = "id_address")
    private Address2 address3;


}
