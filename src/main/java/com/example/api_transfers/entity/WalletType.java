package com.example.api_transfers.entity;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_wallet_type")
public class WalletType {

    @Id
    private long id;

    private String description;

    @Version
    private long version;

    public enum Enum {

        USER(1L, "user"),
        MERCHANT(2L, "merchant");

        private final WalletType walletType;

        private long id;
        private String description;

        Enum(long id, String description) {
            this.walletType = new WalletType(id, description);
        }


        public WalletType get() {
            return walletType;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WalletType that = (WalletType) o;
        return Objects.equals(id, that.id) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description);
    }

    public WalletType(long id, String description) {
        this.id = id;
        this.description = description;
    }

    public WalletType() {}

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

    public long getVersion() {return version;}

    public void setVersion(long version) {this.version = version;}
}