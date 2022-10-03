package co.edu.utp.misionmintic.danianleon.proyectoc3.controller.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublicationDto {
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
