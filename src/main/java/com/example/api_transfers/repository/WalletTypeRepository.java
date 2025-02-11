package com.example.api_transfers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.api_transfers.entity.WalletType;

public interface WalletTypeRepository extends JpaRepository<WalletType, Long> {
}
