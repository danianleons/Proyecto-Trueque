package co.edu.utp.misionmintic.danianleon.proyectoc3.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.utp.misionmintic.danianleon.proyectoc3.model.entity.Category;

import java.util.Optional;




public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Optional<Category> findByName(String string);
}
