package com.example.api_transfers.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "tb_transfers")
public class Transfers {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "wallet_sender_id")
    private Wallet sender;

    @ManyToOne
    @JoinColumn(name = "wallet_reciver_id")
    private Wallet reciver;

    @Column(name = "value")
    private BigDecimal value;

    public Transfers() {
    }

    public Transfers(Wallet sender, Wallet reciver, BigDecimal value) {
        this.sender = sender;
        this.reciver = reciver;
        this.value = value;
    }
}
