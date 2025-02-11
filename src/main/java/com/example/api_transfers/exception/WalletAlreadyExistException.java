package com.example.api_transfers.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class WalletAlreadyExistException extends TransfersException{

    private String detail;

    public WalletAlreadyExistException(String detail) {
        this.detail = detail;
    }

    @Override
    public ProblemDetail toProblemDetail() {
        var pb = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);

        pb.setDetail("Wallet already exist");
        pb.setDetail(detail);

        return pb;
    }
}


