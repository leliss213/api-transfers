package com.example.api_transfers.repository;

import com.example.api_transfers.entity.Transfers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransferRepository extends JpaRepository<Transfers, UUID> {

}
