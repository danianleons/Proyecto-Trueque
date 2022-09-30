package co.edu.utp.misionmintic.danianleon.proyectoc3.controller.dto;

import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
          
    private String email; 
    
    private String password;
    
    private String name;

    private String lastname;        
    
    private String country;

    private String city;

    private String phone;

    public UserDto(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    
}
