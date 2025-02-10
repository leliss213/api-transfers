package com.example.api_transfers.config;

import com.example.api_transfers.entity.WalletType;
import com.example.api_transfers.repository.WalletTypeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import java.util.Arrays;

@Configuration
public class DataLoader implements CommandLineRunner {

    private final WalletTypeRepository walletTypeRepository;

    public DataLoader(WalletTypeRepository walletTypeRepository) {
        this.walletTypeRepository = walletTypeRepository;
    }

    @Override
    public void run(String... args) {
        Arrays.stream(WalletType.Enum.values())
                .map(WalletType.Enum::get)
                .forEach(walletType ->
                        walletTypeRepository.findByDescription(walletType.getDescription())
                                .orElseGet(() -> walletTypeRepository.save(walletType))
                );
    }

}
