package com.br.emakers.ToDoListAPI.data.dto.response;

import com.br.emakers.ToDoListAPI.data.entity.Category;

// Response: Informações devolvidas pelo servidor
public record CategoryResponseDTO(

        Long id,

        String name
) {
    // Construtor usando Category
    public CategoryResponseDTO(Category category) {
        this(category.getIdCategory(), category.getName());
    }
}