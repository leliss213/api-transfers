package com.example.api_transfers.config;

import com.example.api_transfers.entity.WalletType;
import com.example.api_transfers.repository.WalletTypeRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Optional;

@Configuration
public class DataLoader implements CommandLineRunner {

    private final WalletTypeRepository walletTypeRepository;

    public DataLoader(WalletTypeRepository walletTypeRepository) {
        this.walletTypeRepository = walletTypeRepository;
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        // Usar saveAll para evitar múltiplas interações com o banco:
        walletTypeRepository.saveAll(
                Arrays.stream(WalletType.Enum.values())
                        .map(WalletType.Enum::get)
                        .filter(walletType -> !walletTypeRepository.existsById(walletType.getId()))
                        .toList()
        );
    }
}