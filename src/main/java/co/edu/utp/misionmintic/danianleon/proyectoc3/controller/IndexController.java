package co.edu.utp.misionmintic.danianleon.proyectoc3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import co.edu.utp.misionmintic.danianleon.proyectoc3.service.PublicationService;
import co.edu.utp.misionmintic.danianleon.proyectoc3.service.CategoryService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class IndexController {  
    
    private PublicationService catalogService;
    private CategoryService categoryService;

    @GetMapping(value = { "/", "/index", "/index.html" })
    public String goToIndex(Model model) {

        var categories = this.categoryService.getCategories();
        var publications = this.catalogService.getPublications();

        model.addAttribute("categories", categories);
        model.addAttribute("publications", publications);


        return "index";
    }
    @GetMapping("/formulario-registro")
    public String goToRegisterForm(Model model) {
        return "formulario_registro";
    }

    @GetMapping("/formulario-publicacion")
    public String goToPublicationForm(Model model) {
        return "formulario_publicacion";
    }

}