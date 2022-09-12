package com.example.drone.exceptions;

import com.example.drone.UniversalResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Alex Maina
 * @created 08/09/2022
 **/
@ControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(ItemAlreadyExistException.class)
    public ResponseEntity<UniversalResponse> handleItemAlreadyExistsException(ItemAlreadyExistException e) {
        return ResponseEntity.badRequest ()
                .body (UniversalResponse.builder ().status (400).message (e.getMessage ()).build ());
    }

    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<UniversalResponse> handleItemNotFoundException(ItemNotFoundException e){
        return ResponseEntity.badRequest ()
                .body (UniversalResponse.builder ().status (400).message (e.getMessage ()).build ());
    }

    @ExceptionHandler(IllegalOperationException.class)
    public ResponseEntity<UniversalResponse> handleIllegalOperationException(IllegalOperationException e){
        return ResponseEntity.badRequest ()
                .body (UniversalResponse.builder ().status (400).message (e.getMessage ()).build ());
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<UniversalResponse> handleIllegalStateException(IllegalStateException e){
        return ResponseEntity.badRequest ()
                .body (UniversalResponse.builder ().status (400).message (e.getMessage ()).build ());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<UniversalResponse> handleMethodArgumentException(MethodArgumentNotValidException e){
        return ResponseEntity.badRequest ()
                .body (UniversalResponse.builder ().status (400).message (e.getMessage ()).build ());
    }


}
