package com.example.api_transfers.controller;

import com.example.api_transfers.controller.dto.CreateWalletDTO;
import com.example.api_transfers.entity.Wallet;
import com.example.api_transfers.entity.WalletType;
import com.example.api_transfers.service.WalletService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class WalletController {

    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @PostMapping("/wallets")
    public ResponseEntity<Wallet> createWallet(@RequestBody @Valid CreateWalletDTO dto) {

        log.info("Objeto recebido: {}", dto);

        var wallet = walletService.createWallet(dto);

        return ResponseEntity.ok(wallet);
    }
}
