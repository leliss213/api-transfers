package com.example.api_transfers.repository;

import com.example.api_transfers.entity.WalletType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WalletTypeRepository extends JpaRepository<WalletType, Long> {
    Optional<WalletType> findByDescription(String description);
}
