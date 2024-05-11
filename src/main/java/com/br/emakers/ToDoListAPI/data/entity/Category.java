package com.br.emakers.APItest.data.entity;

import com.br.emakers.APItest.data.dto.request.CategoryRequestDTO;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter // Anotações do Lombok pra escrever código frequentemente usado
@Setter
@NoArgsConstructor

@Entity
@Table(name = "category")
public class Category {

    @Id // Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Valor gerado automatiamente de maneira incremental
    private Long idCategory;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Builder
    public Category(CategoryRequestDTO categoryRequestDTO) {
        this.name = categoryRequestDTO.name();
    }
}