package com.example.managementstore.dto;

import java.time.LocalDate;

public class ErrorResponse {

    public String messageError;
    public Integer statusCode;

    public LocalDate time;

    public ErrorResponse(){

    }

    public ErrorResponse(String messageError, Integer statusCode, LocalDate time) {
        this.messageError = messageError;
        this.statusCode = statusCode;
        this.time = time;
    }
}
