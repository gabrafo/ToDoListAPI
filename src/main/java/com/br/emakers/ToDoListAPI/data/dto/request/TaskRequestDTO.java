package com.br.emakers.ToDoListAPI.data.dto.request;

import com.br.emakers.ToDoListAPI.data.entity.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record TaskRequestDTO(

        // Onde ficam os argumentos, que já vem com getters/setters

        @NotBlank(message = "Name is required!") // Verifica se o nome está vazio
        String name,

        @Pattern(regexp = "^(to do|doing|done)$", message = "Situation must be " +
                "'to do', 'doing' or 'done'.") // Expressão regular pra verificar o padrão do campo
        String situation,

        // Nesse caso, categoria pode ser vazia, então não faremos a autentificação dela
        Category category
) {
}
