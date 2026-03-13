package com.bottle.app.domain;

public class BottleNotFoundException extends RuntimeException {
    public BottleNotFoundException(String message) {
        super(message);
    }
}
