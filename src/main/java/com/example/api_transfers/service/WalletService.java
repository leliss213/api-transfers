package com.example.api_transfers.service;

import com.example.api_transfers.controller.dto.CreateWalletDTO;
import com.example.api_transfers.entity.Wallet;
import com.example.api_transfers.exception.WalletAlreadyExistException;
import com.example.api_transfers.repository.WalletRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class WalletService {

    private final WalletRepository walletRepository;

    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    @Transactional
    public Wallet createWallet(CreateWalletDTO dto){

        //busca no banco se possui uma wallet com cpf ou email do objeto recebido dto
        var walletDb = walletRepository.findByCpfCnpjOrEmail(dto.cpfCnpj(), dto.email());

        if(walletDb.isPresent()){
            throw new WalletAlreadyExistException("CPF/CNPJ or email already exist");
        }

        return walletRepository.save(dto.toWallet());
    }
}
