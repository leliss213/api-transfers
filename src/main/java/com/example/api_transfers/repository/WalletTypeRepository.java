package com.example.api_transfers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.api_transfers.entity.WalletType;

import java.util.List;

public interface WalletTypeRepository extends JpaRepository<WalletType, Long> {
    List<WalletType> Id(long id);
}
