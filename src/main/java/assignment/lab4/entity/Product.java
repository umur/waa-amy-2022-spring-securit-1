package assignment.lab4.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private float price;

 // @OneToMany(mappedBy = "product")
    @OneToMany
    @JoinColumn(name = "product_id")
    private List<Review> reviews;

/*

    @JsonManagedReference
    @ManyToMany(mappedBy = "products")
    private List<Category> categories;
*/

 //@JsonManagedReference
  @OneToOne
  //@JoinColumn(name = "id_user")
  private User user;



}


