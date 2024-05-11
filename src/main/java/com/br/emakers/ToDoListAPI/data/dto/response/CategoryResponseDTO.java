package com.br.emakers.APItest.data.dto.response;

import com.br.emakers.APItest.data.entity.Category;

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