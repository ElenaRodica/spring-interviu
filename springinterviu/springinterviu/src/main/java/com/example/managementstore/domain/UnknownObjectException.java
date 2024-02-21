package com.example.managementstore.domain;

public class UnknownObjectException  extends RuntimeException {

    private String errorMessage;

    public UnknownObjectException(){

    }

    public UnknownObjectException(String message, String errorMessage) {
        super(message);
        this.errorMessage = errorMessage;
    }
}
