package com.project.reactor.exception;

public class TodoNotFoundException extends RuntimeException{

    public TodoNotFoundException(String id) {
        super("Todo con ID " + id + " no encontrado.");
    }
}
