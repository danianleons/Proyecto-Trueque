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

        private final PublicationRepository publicationRepository;
        private final CategoryRepository categoryRepository;
        private final UserRepository userRepository;

        @Override
        public PublicationDto getPublicationById(Integer id) {
                var publication = publicationRepository.findById(id).get();
                var publicationDto = PublicationDto.builder()
                                .id(publication.getId())
                                .title(publication.getTitle())
                                .description(publication.getDescription())
                                .status(publication.getStatus())
                                .contactNumber(publication.getContactNumber())
                                .changeFor(publication.getChangeFor())
                                .imageUrl(publication.getImageUrl())
                                .category(new CategoryDto(publication.getCategory().getId(),
                                                publication.getCategory().getName()))
                                .user(new UserDto(publication.getUser().getName(),
                                                publication.getUser().getLastname()))
                                .date(publication.getDate())
                                .build();

                return publicationDto;
        }

        @Override
        public List<PublicationDto> getPublicationsByCategoryId(Integer categoryId) {
                var publications = publicationRepository.findAllByCategoryIdOrderByDateDesc(categoryId);

                var categoryPublications = publications.stream()
                                .map(publication -> PublicationDto.builder()
                                                .title(publication.getTitle())
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
                var publications = publicationRepository.findAllByOrderByDateDesc();

                var categoryPublications = publications.stream()
                                .map(publication -> PublicationDto.builder()
                                                .title(publication.getTitle())
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
                publication.setTitle(publicationDto.getTitle());
                publication.setCategory(category.get());
                publication.setUser(user.get());
                publication.setDate(new Date());

                publicationRepository.save(publication);
        }

        @Override
        public List<PublicationDto> getPublicationsByUserEmail(String userEmail) {
                var publications = publicationRepository.findAllByUserEmailOrderByDateDesc(userEmail);

                var userPublications = publications.stream()
                                .map(publication -> PublicationDto.builder()
                                                .id(publication.getId())
                                                .title(publication.getTitle())
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

        @Override
        public void updatePublication(PublicationDto publication) {
                var publicationOp = publicationRepository.findById(publication.getId());
                if (publicationOp.isEmpty()) {
                        throw new RuntimeException("La publicación no existe");
                }
                var category = categoryRepository.findById(publication.getCategory().getId());
                var user = userRepository.findByEmail(publication.getUser().getEmail());
                var publicationDb = publicationOp.get();
                publicationDb.setTitle(publication.getTitle());
                publicationDb.setDescription(publication.getDescription());
                publicationDb.setChangeFor(publication.getChangeFor());
                publicationDb.setImageUrl(publication.getImageUrl());
                publicationDb.setStatus(publication.getStatus());
                publicationDb.setCategory(category.get());
                publicationDb.setUser(user.get());
                publicationDb = publicationRepository.save(publicationDb);
        }

        @Override
        public void deletePublication(Integer id) {
                var publicationDb = publicationRepository.findById(id);
                if (publicationDb.isEmpty()) {
                        throw new RuntimeException("La publicación no existe");
                }

                publicationRepository.delete(publicationDb.get());
        }

}