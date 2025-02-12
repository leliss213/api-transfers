package com.example.api_transfers.controller;

import com.example.api_transfers.exception.TransfersException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(TransfersException.class)
    public ProblemDetail handleTransfersException(TransfersException e) {
        return e.toProblemDetail();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        var errors = e.getBindingResult().getFieldErrors()
                .stream()
                .map(f -> new InvalidParam(f.getField(), f.getDefaultMessage()))
                .toList();

        var pd = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);

        pd.setTitle("Your parameters are invalid");
        pd.setProperty("InvalidParam", errors);

        return pd;
    }

    private record InvalidParam(String name, String reason){
    }

}
