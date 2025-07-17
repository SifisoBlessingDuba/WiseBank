package za.ac.cput.wisebank.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cardId;
    private String cardNumber;
    private String cardType;
    private Boolean status;
    private double cardLimit;
    private int cvv;
    private LocalDate expiryDate;
    private LocalDate issuedDate;
    @OneToOne
    @JoinColumn(name = "account_id", nullable = false, unique = true)
    private Account account;


    protected Card() {

    }

    public Card(Builder builder) {
        this.cardId = builder.cardId;
        this.cardNumber = builder.cardNumber;
        this.cardType = builder.cardType;
        this.status = builder.status;
        this.cardLimit = builder.cardLimit;
        this.cvv = builder.cvv;
        this.expiryDate = builder.expiryDate;
        this.issuedDate = builder.issuedDate;
    }

    public Integer getCardId() {
        return cardId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardType() {
        return cardType;
    }

    public Boolean getStatus() {
        return status;
    }

    public double isCardLimit() {
        return cardLimit;
    }

    public int getCvv() {
        return cvv;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public LocalDate getIssuedDate() {
        return issuedDate;
    }

    public Account getAccount() {
        return account;
    }

    public double getCardLimit() {
        return cardLimit;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardId=" + cardId +
                ", cardNumber='" + cardNumber + '\'' +
                ", cardType='" + cardType + '\'' +
                ", status=" + status +
                ", cardLimit=" + cardLimit +
                ", cvv=" + cvv +
                ", expiryDate=" + expiryDate +
                ", issuedDate=" + issuedDate +
                ", account=" + account +
                '}';
    }

    public static class Builder {
        private Integer cardId;
        private String cardNumber;
        private String cardType;
        private Boolean status;
        private double cardLimit;
        private int cvv;
        private LocalDate expiryDate;
        private LocalDate issuedDate;
        private Account account;

        public Builder setCardId(Integer cardId) {
            this.cardId = cardId;
            return this;
        }
        public Builder setCardNumber(String cardNumber) {
            this.cardNumber = cardNumber;
            return this;
        }
        public Builder setCardType(String cardType) {
            this.cardType = cardType;
            return this;
        }
        public Builder setStatus(boolean status) {
            this.status = status;
            return this;
        }
        public Builder setCardLimit(double cardLimit) {
            this.cardLimit = cardLimit;
            return this;
        }
        public Builder setCvv(int cvv) {
            this.cvv = cvv;
            return this;
        }
        public Builder setExpiryDate(LocalDate expiryDate) {
            this.expiryDate = expiryDate;
            return this;
        }
        public Builder setIssuedDate(LocalDate issuedDate) {
            this.issuedDate = issuedDate;
            return this;
        }
        public Builder setAccount(Account account) {
            this.account = account;
            return this;
        }
        public Card build() {
            return new Card(this);
        }

    }
}
