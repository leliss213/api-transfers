package com.example.api_transfers.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_wallet_type")
public class WalletType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String description;

    public WalletType() {

    }

    public WalletType(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public enum Enum {

        USER("user"),
        MERCHANT("merchant");

        Enum(String description) {
            this.description = description;
        }

        private String description;
        
        public WalletType get(){
            return new WalletType(description);
        }
    }
}
