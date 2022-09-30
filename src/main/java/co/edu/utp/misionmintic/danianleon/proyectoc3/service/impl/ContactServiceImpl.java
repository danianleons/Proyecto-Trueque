package co.edu.utp.misionmintic.danianleon.proyectoc3.service.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import co.edu.utp.misionmintic.danianleon.proyectoc3.controller.dto.ContactDto;
import co.edu.utp.misionmintic.danianleon.proyectoc3.model.entity.Contact;
import co.edu.utp.misionmintic.danianleon.proyectoc3.model.repository.ContactRepository;
import co.edu.utp.misionmintic.danianleon.proyectoc3.service.ContactService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    @Override
    public void saveContact(ContactDto contact) {

        var entity = new Contact();
        entity.setDate(new Date());
        entity.setCountry(contact.getCountry());
        entity.setName(contact.getName());
        entity.setEmail(contact.getEmail());
        entity.setSubject(contact.getSubject());
        entity.setMessage(contact.getMessage());

        contactRepository.save(entity);

    }
    
}
