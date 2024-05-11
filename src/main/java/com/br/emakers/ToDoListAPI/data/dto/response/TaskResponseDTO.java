package com.br.emakers.ToDoListAPI.data.dto.response;

import com.br.emakers.ToDoListAPI.data.entity.Task;

public record TaskResponseDTO(
        Long id,

        String name,

        String situation,

        CategoryResponseDTO categoryResponseDTO
) {
    public TaskResponseDTO(Task task){
        this(task.getIdTask(), task.getName(), task.getSituation(), new CategoryResponseDTO(task.getCategory()));
    }
}
