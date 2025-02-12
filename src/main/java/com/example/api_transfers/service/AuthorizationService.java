package com.example.api_transfers.service;

import com.example.api_transfers.cliente.AuthorizationClient;
import com.example.api_transfers.controller.dto.TransferDTO;
import com.example.api_transfers.exception.TransfersException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthorizationService {

    private final AuthorizationClient authorizationClient;

    public AuthorizationService(AuthorizationClient authorizationClient) {
        this.authorizationClient = authorizationClient;
    }

    public boolean isAuthorized(TransferDTO transferDTO){
        var resp = authorizationClient.isAuthorized();

        if(resp.getStatusCode().isError()){
            throw new TransfersException();
        }

        return Objects.requireNonNull(resp.getBody()).authorized();
    }
}
