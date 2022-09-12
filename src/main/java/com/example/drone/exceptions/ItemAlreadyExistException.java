package com.example.drone.exceptions;

public class ItemAlreadyExistException extends IllegalArgumentException{
    public ItemAlreadyExistException(String s){
        super(s);
    }

}
