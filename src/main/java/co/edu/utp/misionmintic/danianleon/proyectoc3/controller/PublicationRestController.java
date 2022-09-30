package co.edu.utp.misionmintic.danianleon.proyectoc3.controller;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.utp.misionmintic.danianleon.proyectoc3.controller.dto.PublicationDto;
import co.edu.utp.misionmintic.danianleon.proyectoc3.service.PublicationService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("api/publication")
public class PublicationRestController {

    private PublicationService publicationService;

    @PostMapping
    public ResponseEntity<?> createPublication(@RequestBody PublicationDto publicationDto) {
        publicationService.createPublication(publicationDto);

        return ResponseEntity.ok().build();
    }

}
