package com.example.api_transfers.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class WalletNotFoundException extends TransfersException {

    private Long walletId;

    public WalletNotFoundException(Long walletId) {
        this.walletId = walletId;
    }

    @Override
    public ProblemDetail toProblemDetail() {
        var pd = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);

        pd.setDetail("Wallet not found");
        pd.setDetail("No one wallet found for this ID" + walletId);

        return pd;
    }
}
