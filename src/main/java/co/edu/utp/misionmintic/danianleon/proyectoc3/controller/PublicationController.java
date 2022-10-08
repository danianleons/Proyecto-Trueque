package co.edu.utp.misionmintic.danianleon.proyectoc3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import co.edu.utp.misionmintic.danianleon.proyectoc3.service.PublicationService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class PublicationController {  
    
    private PublicationService publicationService;
      
    @GetMapping("/publication/{id}") 
    public String getPublication(@PathVariable("id") Integer Id, Model model) {
        var publication = publicationService.getPublicationById(Id);
       
        model.addAttribute("publication", publication);

        return "updatePublicationForm";
    }
}
