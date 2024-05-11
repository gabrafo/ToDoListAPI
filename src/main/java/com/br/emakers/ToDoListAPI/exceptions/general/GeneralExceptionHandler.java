package com.br.emakers.ToDoListAPI.exceptions.general;

import com.br.emakers.ToDoListAPI.exceptions.RestErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    private ResponseEntity<RestErrorMessage> entityNotFoundHandler(EntityNotFoundException e) {
        RestErrorMessage errorMessage = new RestErrorMessage(HttpStatus.BAD_REQUEST, e.getMessage());
        return ResponseEntity.status(errorMessage.status()).body(errorMessage);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity<List<RestErrorMessage>> methodArgumentNotValidHandler(MethodArgumentNotValidException e) {
        List<RestErrorMessage> errors = e.getBindingResult().getFieldErrors()
                .stream().map(fieldError -> new RestErrorMessage(HttpStatus.BAD_REQUEST, fieldError.getDefaultMessage()))
                .toList();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }
}
