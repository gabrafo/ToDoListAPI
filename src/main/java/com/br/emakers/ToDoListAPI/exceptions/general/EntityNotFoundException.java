package com.br.emakers.ToDoListAPI.exceptions.general;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(Long id) {
        super("Entity with ID " + id + " has not been found.");
    }
}
