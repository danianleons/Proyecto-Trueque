package co.edu.utp.misionmintic.danianleon.proyectoc3.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import co.edu.utp.misionmintic.danianleon.proyectoc3.controller.dto.ContactDto;
import co.edu.utp.misionmintic.danianleon.proyectoc3.service.ContactService;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@RestController 
@RequestMapping("/contact/register")
@Slf4j
public class ContactRestController {
    private ContactService contactService;

    @PostMapping
    public ResponseEntity<?> postContactRegister(@RequestBody ContactDto contactInfo) {
        log.info(contactInfo.toString());

        contactService.saveContact(contactInfo);

        return ResponseEntity.ok().build();
    }
}

