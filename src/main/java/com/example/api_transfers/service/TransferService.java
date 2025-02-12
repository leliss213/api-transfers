package com.example.api_transfers.service;

import com.example.api_transfers.cliente.AuthorizationClient;
import com.example.api_transfers.controller.dto.TransferDTO;
import com.example.api_transfers.entity.Transfers;
import com.example.api_transfers.entity.Wallet;
import com.example.api_transfers.exception.InsufficientBalanceException;
import com.example.api_transfers.exception.WalletNotAllowedException;
import com.example.api_transfers.exception.WalletNotFoundException;
import com.example.api_transfers.exception.transferNotAuthorizedException;
import com.example.api_transfers.repository.TransferRepository;
import com.example.api_transfers.repository.WalletRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import javax.naming.InsufficientResourcesException;
import java.util.concurrent.CompletableFuture;

@Service
public class TransferService {

    private final TransferRepository transferRepository;
    private final AuthorizationService authorizationService;
    private final NotificationService notificationService;
    private final WalletRepository walletRepository;

    public TransferService(TransferRepository transferRepository,
                           AuthorizationService authorizationService,
                           NotificationService notificationService, WalletRepository walletRepository) {
        this.transferRepository = transferRepository;
        this.authorizationService = authorizationService;
        this.notificationService = notificationService;
        this.walletRepository = walletRepository;
    }

    @Transactional
    public Transfers transfer(@Valid TransferDTO dto) {

        var sender = walletRepository.findById(dto.payer())
                .orElseThrow(() -> new WalletNotFoundException(dto.payer()));

        var reciver = walletRepository.findById(dto.payee())
                .orElseThrow(() -> new WalletNotFoundException(dto.payee()));

        validadeTransfer(dto, sender);

        sender.debit(dto.value());
        reciver.credit(dto.value());

        var transfer = new Transfers(sender, reciver, dto.value());

        walletRepository.save(sender);
        walletRepository.save(reciver);
        var transferResult = transferRepository.save(transfer);

        CompletableFuture.runAsync(() -> notificationService.sendNotification(transferResult));

        return transferResult;
    }

    public void validadeTransfer(TransferDTO dto, Wallet sender){

        if(!sender.isTransferAllowedForWalletType()){
            throw new WalletNotAllowedException();
        }

        if(!sender.isBalanceBiggerThan(dto.value())){
            throw new InsufficientBalanceException();
        }

        if(!authorizationService.isAuthorized(dto)){
            throw new transferNotAuthorizedException();
        }
    }
}
