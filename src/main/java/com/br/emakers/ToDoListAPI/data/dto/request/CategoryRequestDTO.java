package com.br.emakers.APItest.data.dto.request;

import jakarta.validation.constraints.NotBlank;

// Request: Informações dadas pelo Cliente
public record CategoryRequestDTO(
        @NotBlank(message = "Name is required!")
        String name
) {
}
