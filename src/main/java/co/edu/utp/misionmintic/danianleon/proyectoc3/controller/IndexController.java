package co.edu.utp.misionmintic.danianleon.proyectoc3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    @GetMapping("/index/{id}")    
    public String loadCatalogById(@PathVariable("id") Integer id, Model model) {
        
        var categories = categoryService.getCategories();
        model.addAttribute("categories", categories);

        var categoryOp = this.categoryService.getCategoryById(id);
        if (categoryOp.isEmpty()) {
            // Mostrar mensaje de error
            model.addAttribute("error", "La categoria no existe");
        } else {
            var category = categoryOp.get();

            model.addAttribute("title", category.getName());
            model.addAttribute("id", category.getId());

            var categoryPublications = this.catalogService.getPublicationsByCategoryId(id);

            model.addAttribute("publications", categoryPublications);
        }
        model.addAttribute("page", "catalog");

        return "index";
    }

    
    @GetMapping("/register-form")
    public String goToRegisterForm(Model model) {
        return "registerForm";
    }

    @GetMapping("/publication-form")
    public String goToPublicationForm(Model model) {
        return "publicationForm";
    }

     @GetMapping("/contact-form")
    public String goToContactForm(Model model) {
        return "contactForm";
    }

    @GetMapping("/my-posts/{email}")
    public String goToMyPosts(@PathVariable("email") String userEmail, Model model) {
        var publications = this.catalogService.getPublicationsByUserEmail(userEmail);
        model.addAttribute("publications", publications);
        return "myposts";
    }

}