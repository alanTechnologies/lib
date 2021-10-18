package com.lib.system.exceptions;

public class BookAlreadyRentException extends Exception{

    public BookAlreadyRentException(String message){
        super(message);
    }
}
