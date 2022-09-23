package co.edu.utp.misionmintic.danianleon.proyectoc3.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.utp.misionmintic.danianleon.proyectoc3.controller.dto.UserDto;
import co.edu.utp.misionmintic.danianleon.proyectoc3.service.SecurityService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("api/user")
public class UserRestController {

    private SecurityService securityService;

    @PostMapping
    public  ResponseEntity<?> createUser(@RequestBody UserDto userDto){
        securityService.createUser(userDto);

        return ResponseEntity.ok().build();
    }
    
}
