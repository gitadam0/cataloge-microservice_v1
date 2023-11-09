package com.example.Cataloguemicroservice.Exceptions;

public class ProductNotFoundException extends Exception {
    public ProductNotFoundException(String s) {
        super(s);
    }
}
