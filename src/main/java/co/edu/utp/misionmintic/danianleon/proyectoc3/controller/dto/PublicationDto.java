package co.edu.utp.misionmintic.danianleon.proyectoc3.controller.dto;

import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublicationDto {
    
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    private String description;
    private String changeFor;
    private String contactNumber;
    private String imageUrl;
    private String status;
    private CategoryDto category;
    private UserDto user;
    private Date date;
}
