package com.example.Cataloguemicroservice.Exceptions;

public class CategoryNotFoundException extends Exception {
    public CategoryNotFoundException(String message) {
        super(message);
    }
}
