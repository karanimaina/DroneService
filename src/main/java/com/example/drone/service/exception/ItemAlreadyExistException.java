package com.example.drone.service.exception;

public class ItemAlreadyExistException extends IllegalArgumentException{
    public ItemAlreadyExistException(String s){
        super(s);
    }

}
