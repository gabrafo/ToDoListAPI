package com.br.emakers.APItest.exceptions.general;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(Long id) {
        super("Entity with ID " + id + " has not been found.");
    }
}
