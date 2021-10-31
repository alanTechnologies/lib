package com.lib.system.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_ACCEPTABLE, reason="Book already rented")
public class BookAlreadyRentException extends Exception{

    public BookAlreadyRentException(String message){
        super(message);
    }
}
