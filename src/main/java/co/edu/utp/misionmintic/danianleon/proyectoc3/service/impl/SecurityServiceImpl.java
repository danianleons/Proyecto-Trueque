package co.edu.utp.misionmintic.danianleon.proyectoc3.service.impl;

import org.springframework.stereotype.Service;

import co.edu.utp.misionmintic.danianleon.proyectoc3.controller.dto.UserDto;
import co.edu.utp.misionmintic.danianleon.proyectoc3.model.entity.User;
import co.edu.utp.misionmintic.danianleon.proyectoc3.model.repository.UserRepository;
import co.edu.utp.misionmintic.danianleon.proyectoc3.service.SecurityService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SecurityServiceImpl implements SecurityService {

    private final UserRepository userRepository;

    @Override
    public UserDto validateUser(String username, String password) {

        var userOp = userRepository.findByEmailAndPassword(username, password);
        if (userOp.isEmpty()) {
            throw new RuntimeException("Credenciales Inválidas");
        }

        var user = userOp.get();
        return UserDto.builder()
                .name(user.getName())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .build();
    }

    @Override
    public void createUser(UserDto userDto) {
        var user = new User();
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setName(userDto.getName());
        user.setLastname(userDto.getLastname());
        user.setCountry(userDto.getCountry());
        user.setCity(userDto.getCity());
        user.setPhone(userDto.getPhone());

        userRepository.save(user);
    }

}
