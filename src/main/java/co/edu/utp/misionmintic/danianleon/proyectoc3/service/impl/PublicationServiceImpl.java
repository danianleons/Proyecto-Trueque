package co.edu.utp.misionmintic.danianleon.proyectoc3.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import co.edu.utp.misionmintic.danianleon.proyectoc3.controller.dto.PublicationDto;
import co.edu.utp.misionmintic.danianleon.proyectoc3.controller.dto.CategoryDto;
import co.edu.utp.misionmintic.danianleon.proyectoc3.model.entity.Publication;
import co.edu.utp.misionmintic.danianleon.proyectoc3.model.repository.CategoryRepository;
import co.edu.utp.misionmintic.danianleon.proyectoc3.model.repository.PublicationRepository;
import co.edu.utp.misionmintic.danianleon.proyectoc3.service.PublicationService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PublicationServiceImpl implements PublicationService {

        private final PublicationRepository publicacionRepository;
        private final CategoryRepository categoryRepository;

        @Override
        public List<PublicationDto> getPublicationsByCategoryId(Integer categoryId) {
                var publications = publicacionRepository.findAllByCategoryId(categoryId);

                var categoryPublications = publications.stream()
                                .map(publication -> PublicationDto.builder()
                                                .title(publication.getTittle())
                                                .description(publication.getDescription())
                                                .changeFor(publication.getChangeFor())
                                                .imageUrl(publication.getImageUrl())
                                                .category(new CategoryDto(publication.getCategory().getId(),
                                                                publication.getCategory().getName()))
                                                .build())
                                .collect(Collectors.toList());

                return categoryPublications;
        }

        @Override
        public List<PublicationDto> getPublications() {
                var publications = publicacionRepository.findAll();

                var categoryPublications = publications.stream()
                                .map(publication -> PublicationDto.builder()
                                                .title(publication.getTittle())
                                                .description(publication.getDescription())
                                                .changeFor(publication.getChangeFor())
                                                .imageUrl(publication.getImageUrl())
                                                .category(new CategoryDto(publication.getCategory().getId(),
                                                                publication.getCategory().getName()))
                                                .build())
                                .collect(Collectors.toList());

                return categoryPublications;
        }

        @Override
        public void createPublication(PublicationDto publicationDto) {

                var category = categoryRepository.findById(publicationDto.getCategory().getId());
                var publication = new Publication();
                publication.setChangeFor(publicationDto.getChangeFor());
                publication.setContactNumber(publicationDto.getContactNumber());
                publication.setDescription(publicationDto.getDescription());
                publication.setImageUrl(publicationDto.getImageUrl());
                publication.setStatus(publicationDto.getStatus());
                publication.setTittle(publicationDto.getTitle());
                publication.setCategory(category.get());

                publicacionRepository.save(publication);
        }

}
