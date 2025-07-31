package za.ac.cput.wisebank.domain;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Beneficiary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer beneficiaryId;



    private int userId;
    private String accountNumber;
    private String name;
    private String bankName;
    private LocalDate addedAt;

    // Many Beneficiaries → One User
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    protected Beneficiary() {}

    public Beneficiary(Builder builder) {
        this.beneficiaryId = builder.beneficiaryId;
        this.user = builder.user;

    public Beneficiary(Builder builder) {
        this.beneficiaryId = builder.beneficiaryId;
        this.userId = builder.userId;

        this.accountNumber = builder.accountNumber;
        this.name = builder.name;
        this.bankName = builder.bankName;
        this.addedAt = builder.addedAt;
    }

    // Getters
    public Integer getBeneficiaryId() {
        return beneficiaryId;
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

    }

    // Getters
    public int getBeneficiaryId() {
        return beneficiaryId;
    }
    public int getUserId() {
        return userId;
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
                "beneficiaryId=" + beneficiaryId +

                ", user=" + (user != null ? user.getId() : null) +

                ", userId=" + userId +
                ", accountNumber='" + accountNumber + '\'' +
                ", name='" + name + '\'' +
                ", bankName='" + bankName + '\'' +
                ", addedAt=" + addedAt +
                '}';
    }


    public static class Builder {
        private Integer beneficiaryId;
        private User user;
    public static class Builder {
        private Integer beneficiaryId;
        private int userId;
        private String accountNumber;
        private String name;
        private String bankName;
        private LocalDate addedAt;

        public Builder() {}


        public Builder setBeneficiaryId(Integer beneficiaryId) {
            this.beneficiaryId = beneficiaryId;
            return this;
        }


        public Builder setUser(User user) {
            this.user = user;
            return this;
        }


        public Builder setUserId(int userId) {
            this.userId = userId;
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
