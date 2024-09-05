package com.example.demo.exception;

public class BookTitleAlreadyExistsException extends RuntimeException{

    public BookTitleAlreadyExistsException(String message){
        super(message);
    }
}
