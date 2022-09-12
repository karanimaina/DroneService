package com.example.drone.exceptions;

public class ItemNotFoundException extends IllegalArgumentException{
    public ItemNotFoundException(String message) {
        super (message);
    }
}
