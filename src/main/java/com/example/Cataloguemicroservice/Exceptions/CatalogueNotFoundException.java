package com.example.Cataloguemicroservice.Exceptions;

public class CatalogueNotFoundException extends RuntimeException {
    public CatalogueNotFoundException(String message) {
        super(message);
    }
}
