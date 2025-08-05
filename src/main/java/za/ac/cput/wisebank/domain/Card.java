package za.ac.cput.wisebank.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

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
    @OneToMany
    @JoinColumn(name = "account_id")
    private List<Account> account;
    @OneToOne
    @JoinColumn(name = "User_Id")
    private User user;


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
        this.account = builder.account;
        this.user = builder.user;
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

    public List<Account> getAccount() {
        return account;
    }

    public double getCardLimit() {
        return cardLimit;
    }

    public User getUser() {
        return user;
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
                ", user=" + user +
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
        private List<Account> account;
        private User user;


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
        public Builder setAccount(List<Account> account) {
            this.account = account;
            return this;
        }
        public Builder setUser(User user) {
            this.user = user;
            return this;
        }
        public Card build() {
            return new Card(this);
        }

    }
}
