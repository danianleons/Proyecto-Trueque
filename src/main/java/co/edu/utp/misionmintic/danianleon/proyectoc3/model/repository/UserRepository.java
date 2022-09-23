package co.edu.utp.misionmintic.danianleon.proyectoc3.model.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.utp.misionmintic.danianleon.proyectoc3.model.entity.User;

public interface UserRepository extends JpaRepository<User, String> {
    
    Optional<User> findByEmailAndPassword(String username, String password);
}
