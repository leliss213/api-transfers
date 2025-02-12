package com.example.api_transfers.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class transferNotAuthorizedException extends TransfersException{

    @Override
    public ProblemDetail toProblemDetail() {
        var pd = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);

        pd.setDetail("Transfer not authorized");
        pd.setTitle("Authorization server not authorized this transfer.");

        return pd;

    }
}
