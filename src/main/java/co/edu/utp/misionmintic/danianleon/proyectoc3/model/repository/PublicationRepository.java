package co.edu.utp.misionmintic.danianleon.proyectoc3.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.utp.misionmintic.danianleon.proyectoc3.model.entity.Publication;

public interface PublicationRepository extends JpaRepository<Publication, Integer> {

    List<Publication> findAllByOrderByDateDesc();

    List<Publication> findAllByCategoryIdOrderByDateDesc(Integer categoryId);

    List<Publication> findAllByCategoryIdIn(List<Integer> categoryIds);

    List<Publication> findAllByUserEmailOrderByDateDesc(String userEmail);

}
