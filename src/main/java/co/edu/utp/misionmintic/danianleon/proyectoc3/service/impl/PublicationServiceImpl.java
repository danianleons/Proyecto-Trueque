package co.edu.utp.misionmintic.danianleon.proyectoc3.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import co.edu.utp.misionmintic.danianleon.proyectoc3.controller.dto.PublicationDto;
import co.edu.utp.misionmintic.danianleon.proyectoc3.controller.dto.UserDto;
import co.edu.utp.misionmintic.danianleon.proyectoc3.controller.dto.CategoryDto;
import co.edu.utp.misionmintic.danianleon.proyectoc3.model.entity.Publication;
import co.edu.utp.misionmintic.danianleon.proyectoc3.model.repository.CategoryRepository;
import co.edu.utp.misionmintic.danianleon.proyectoc3.model.repository.PublicationRepository;
import co.edu.utp.misionmintic.danianleon.proyectoc3.model.repository.UserRepository;
import co.edu.utp.misionmintic.danianleon.proyectoc3.service.PublicationService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PublicationServiceImpl implements PublicationService {

        private final PublicationRepository publicacionRepository;
        private final CategoryRepository categoryRepository;
        private final UserRepository userRepository;

        @Override
        public List<PublicationDto> getPublicationsByCategoryId(Integer categoryId) {
                var publications = publicacionRepository.findAllByCategoryIdOrderByDateDesc(categoryId);

                var categoryPublications = publications.stream()
                                .map(publication -> PublicationDto.builder()
                                                .title(publication.getTittle())
                                                .description(publication.getDescription())
                                                .changeFor(publication.getChangeFor())
                                                .imageUrl(publication.getImageUrl())
                                                .category(new CategoryDto(publication.getCategory().getId(),
                                                                publication.getCategory().getName()))
                                                .user(new UserDto(publication.getUser().getName(),
                                                                publication.getUser().getLastname()))
                                                .date(publication.getDate())
                                                .build())
                                .collect(Collectors.toList());

                return categoryPublications;
        }

        @Override
        public List<PublicationDto> getPublications() {
                var publications = publicacionRepository.findAllByOrderByDateDesc();

                var categoryPublications = publications.stream()
                                .map(publication -> PublicationDto.builder()
                                                .title(publication.getTittle())
                                                .description(publication.getDescription())
                                                .changeFor(publication.getChangeFor())
                                                .imageUrl(publication.getImageUrl())
                                                .category(new CategoryDto(publication.getCategory().getId(),
                                                                publication.getCategory().getName()))
                                                .user(new UserDto(publication.getUser().getName(),
                                                                publication.getUser().getLastname()))
                                                .date(publication.getDate())
                                                .build())
                                .collect(Collectors.toList());

                return categoryPublications;
        }

        @Override
        public void createPublication(PublicationDto publicationDto) {

                var category = categoryRepository.findById(publicationDto.getCategory().getId());
                var user = userRepository.findByEmail(publicationDto.getUser().getEmail());
                var publication = new Publication();
                publication.setChangeFor(publicationDto.getChangeFor());
                publication.setContactNumber(publicationDto.getContactNumber());
                publication.setDescription(publicationDto.getDescription());
                publication.setImageUrl(publicationDto.getImageUrl());
                publication.setStatus(publicationDto.getStatus());
                publication.setTittle(publicationDto.getTitle());
                publication.setCategory(category.get());
                publication.setUser(user.get());
                publication.setDate(new Date());

                publicacionRepository.save(publication);
        }

        @Override
        public List<PublicationDto> getPublicationsByUserEmail(String userEmail) {
                var publications = publicacionRepository.findAllByUserEmailOrderByDateDesc(userEmail);

                var userPublications = publications.stream()
                                .map(publication -> PublicationDto.builder()
                                                .title(publication.getTittle())
                                                .description(publication.getDescription())
                                                .changeFor(publication.getChangeFor())
                                                .imageUrl(publication.getImageUrl())
                                                .category(new CategoryDto(publication.getCategory().getId(),
                                                                publication.getCategory().getName()))
                                                .user(new UserDto(publication.getUser().getName(),
                                                                publication.getUser().getLastname()))
                                                .date(publication.getDate())
                                                .build())
                                .collect(Collectors.toList());

                return userPublications;
        }

}
