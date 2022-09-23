package co.edu.utp.misionmintic.danianleon.proyectoc3.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import co.edu.utp.misionmintic.danianleon.proyectoc3.controller.dto.CategoryDto;
import co.edu.utp.misionmintic.danianleon.proyectoc3.model.repository.CategoryRepository;
import co.edu.utp.misionmintic.danianleon.proyectoc3.service.CategoryService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryDto> getCategories() {
        var categories = categoryRepository.findAll(Sort.by("name"));

        return categories.stream()
                .map(category -> new CategoryDto(category.getId(), category.getName()))
                .collect(Collectors.toList());

    }

    @Override
    public Optional<CategoryDto> getCategoryById(Integer id) {
        var category = categoryRepository.findById(id);

        if (category.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(new CategoryDto(
                category.get().getId(),
                category.get().getName()));
    }
}
