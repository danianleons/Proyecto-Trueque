package co.edu.utp.misionmintic.danianleon.proyectoc3.service;

import java.util.List;
import co.edu.utp.misionmintic.danianleon.proyectoc3.controller.dto.PublicationDto;

public interface PublicationService {

    PublicationDto getPublicationById(Integer Id);

    List<PublicationDto> getPublications();

    List<PublicationDto> getPublicationsByCategoryId(Integer categoryId);

    void createPublication(PublicationDto publication);

    void updatePublication(PublicationDto publication);

    void deletePublication(Integer id);
    
    List<PublicationDto> getPublicationsByUserEmail(String userEmail);
    
}
