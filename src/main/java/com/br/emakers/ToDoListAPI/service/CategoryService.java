package com.br.emakers.APItest.service;

import com.br.emakers.APItest.data.dto.request.CategoryRequestDTO;
import com.br.emakers.APItest.data.dto.response.CategoryResponseDTO;
import com.br.emakers.APItest.data.entity.Category;
import com.br.emakers.APItest.exceptions.general.EntityNotFoundException;
import com.br.emakers.APItest.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

// Implementação do CRUD

@Service
public class CategoryService {

    @Autowired // Gerencia e injeta a dependência em tempo de execução
    private CategoryRepository categoryRepository;

    public List<CategoryResponseDTO> getAllCategories(){
        List<Category> categories = categoryRepository.findAll();

        // Passa por todas as categorias e cria uma CateogyResponseDTO com base em cada uma delas p/ retornar
        // Facilita o gerenciamento das categorias
        return categories.stream().map(CategoryResponseDTO::new).collect(Collectors.toList());
    }


    public CategoryResponseDTO getCategoryById(Long idCategory){
        Category category = getCategoryEntityById(idCategory);

        return new CategoryResponseDTO(category);
    }

    public CategoryResponseDTO createCategory(CategoryRequestDTO categoryRequestDTO){
        String categoryName = categoryRequestDTO.name();

        Category category = new Category(categoryRequestDTO);
        categoryRepository.save(category); // Salva a categoria/Cria uma nova categoria
        return new CategoryResponseDTO(category);
    }

    public CategoryResponseDTO updateCategory(Long idCategory, CategoryRequestDTO categoryRequestDTO){
        Category category = getCategoryEntityById(idCategory);

        category.setName(categoryRequestDTO.name());
        categoryRepository.save(category);
        return new CategoryResponseDTO(category);
    }

    public String deleteCategory(Long idCategory){
        categoryRepository.deleteById(idCategory);
        return "Category with ID " + idCategory + " was deleted successfully.";
    }

    private Category getCategoryEntityById(Long idCategory){
        // O .orElse() responde o que irá acontecer caso o item de CategoryRepository seja nulo
        return categoryRepository.findById(idCategory).orElseThrow(()->new EntityNotFoundException(idCategory));
    }
}
