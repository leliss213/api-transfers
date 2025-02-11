package com.example.api_transfers.controller;

import com.example.api_transfers.exception.TransfersException;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(TransfersException.class)
    public ProblemDetail handleTransfersException(TransfersException e) {
        return e.toProblemDetail();
    }
}
