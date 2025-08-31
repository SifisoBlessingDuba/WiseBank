package za.ac.cput.wisebank.domain;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Beneficiary {

    @Id
    @Column(name = "account_number")
    private String accountNumber;
    private String name;
    private String bankName;
    private LocalDate addedAt;
    @ManyToOne
    @JoinColumn(name = "user_id"  , referencedColumnName = "user_id")
    @com.fasterxml.jackson.annotation.JsonBackReference
    private User user;


    protected Beneficiary() {

    }

    public Beneficiary(Builder builder) {
        this.user = builder.user;
        this.accountNumber = builder.accountNumber;
        this.name = builder.name;
        this.bankName = builder.bankName;
        this.addedAt = builder.addedAt;
    }

    public User getUser() {
        return user;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public String getBankName() {
        return bankName;
    }

    public LocalDate getAddedAt() {
        return addedAt;
    }

    @Override
    public String toString() {
        return "Beneficiary{" +
                ", user=" + (user != null ? user.getUserid(): null) +
                ", accountNumber='" + accountNumber + '\'' +
                ", name='" + name + '\'' +
                ", bankName='" + bankName + '\'' +
                ", addedAt=" + addedAt +
                '}';
    }

    public static class Builder {
        private User user;
        private String accountNumber;
        private String name;
        private String bankName;
        private LocalDate addedAt;


        public Builder setUser(User user) {
            this.user = user;
            return this;
        }

        public Builder setAccountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setBankName(String bankName) {
            this.bankName = bankName;
            return this;
        }

        public Builder setAddedAt(LocalDate addedAt) {
            this.addedAt = addedAt;
            return this;
        }

        public Beneficiary build() {
            return new Beneficiary(this);
        }
    }
}
