package co.edu.utp.misionmintic.danianleon.proyectoc3.model.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id   
    private String email; 
    
    private String password;
    
    private String name;

    private String lastname;        
    
    private String country;

    private String city;

    private String phone;

    @OneToMany(mappedBy = "user")
    private List<Publication> publications;
}
