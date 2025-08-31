package za.ac.cput.wisebank.domain;


import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private String idNumber;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String phoneNumber;
    private String address;
    private LocalDate createdAt;
    private LocalDate lastLogin;

    @OneToMany(mappedBy = "user")

    @JsonIgnore
    private List<Beneficiary> beneficiaries;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Notification> notifications;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Message> messages;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Card> cards;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Loan> loans;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Account> accounts;


    public User(){

    }

    public User (Builder builder) {
        this.email = builder.email;
        this.password = builder.password;
        this.idNumber = builder.idNumber;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.dateOfBirth = builder.dateOfBirth;
        this.phoneNumber = builder.phoneNumber;
        this.address = builder.address;
        this.createdAt = builder.createdAt;
        this.lastLogin = builder.lastLogin;
       // this.accounts = builder.accounts;
        this.beneficiaries = builder.beneficiaries;
        this.messages = builder.messages;
        this.notifications = builder.notifications;
        this.loans = builder.loans;
        this.cards = builder.cards;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public LocalDate getLastLogin() {
        return lastLogin;
    }

  //  public List<Account> getAccount() {
//        return accounts;
//    }

    public List<Beneficiary> getBeneficiary() {
        return beneficiaries;
    }

    public List<Message> getMessage() {
        return messages;
    }

    public List<Notification> getNotification() {
        return notifications;
    }

    public List<Loan> getLoan() {
        return loans;
    }

    public List<Card> getCard() {
        return cards;
    }

    @Override
    public String toString() {
        return "User{" +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", idNumber=" + idNumber +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", phoneNumber=" + phoneNumber +
                ", address='" + address + '\'' +
                ", createdAt=" + createdAt +
                ", lastLogin='" + lastLogin + '\'' +
      //          ", account=" + accounts +
                ", beneficiary=" + beneficiaries +
                ", message=" + messages +
                ", notification=" + notifications +
                ", loan=" + loans +
                ", card=" + cards +
                '}';
    }

    public void setPassword(String newPassword) {
    }


    public static class Builder {
        private String idNumber;
        private String email;
        private String password;
        private String firstName;
        private String lastName;
        private LocalDate dateOfBirth;
        private String phoneNumber;
        private String address;
        private LocalDate createdAt;
        private LocalDate lastLogin;
      //  private List<Account> accounts;
        private List<Beneficiary> beneficiaries;
        private List<Message> messages;
        private List<Notification> notifications;
        private List<Loan> loans;
        private List<Card> cards;




    public Builder setEmail(String email){
            this.email = email;
            return this;
    }
    public Builder setPassword(String password){
            this.password = password;
            return this;
    }
    public Builder setIdNumber(String idNumber){
            this.idNumber = idNumber;
            return this;
    }
    public Builder setFirstName(String firstName){
            this.firstName = firstName;
            return this;
    }
    public Builder setLastName(String lastName){
            this.lastName = lastName;
            return this;
    }
    public Builder setDateOfBirth(LocalDate dateOfBirth){
            this.dateOfBirth = dateOfBirth;
            return this;
    }
    public Builder setPhoneNumber(String phoneNumber){
            this.phoneNumber = phoneNumber;
            return this;
    }
    public Builder setAddress(String address){
            this.address = address;
            return this;
    }
    public Builder setCreatedAt(LocalDate createdAt){
            this.createdAt = createdAt;
            return this;
    }
    public Builder setLastLogin(LocalDate lastLogin){
            this.lastLogin = lastLogin;
            return this;
    }
//   public Builder setAccount(List<Account> accounts){
//            this.accounts = accounts;
//            return this;
//   }
   public Builder setBeneficiary(List<Beneficiary> beneficiaries){
            this.beneficiaries = beneficiaries;
            return this;
   }
  public Builder setMessage(List<Message> messages){
            this.messages= messages;
            return this;
  }
  public Builder setNotification(List<Notification> notifications){
            this.notifications = notifications;
            return this;
  }
  public Builder setLoan(List<Loan> loans){
            this.loans = loans;
            return this;
  }
  public Builder setCard(List<Card> cards){
            this.cards = cards;
            return this;
  }

    public User build()  {
            return new User(this);
    }
}

}
