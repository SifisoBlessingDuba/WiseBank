package za.ac.cput.wisebank.domain;


import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userid;
    private String email;
    private String password;
    private int idNumber;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private Long phoneNumber;
    private String address;
    private LocalDate createdAt;
    private String lastLogin;

    @OneToOne
    @JoinColumn(name = "account_id", referencedColumnName = "account_id")
    private Account account;

    @OneToOne
    @JoinColumn(name = "loan_id", referencedColumnName = "loan_id")
    private LoanPayment loanpayment;

    @OneToOne
    @JoinColumn(name = "beneficiary_id", referencedColumnName = "beneficiary_id")
    private Beneficiary beneficiary;

    @OneToOne
    @JoinColumn(name = "message_id", referencedColumnName = "message_id")
    private Message message;

    @OneToOne
    @JoinColumn(name = "notification_id", referencedColumnName = "notification_id")
    private Notification notification;

    protected User(){

    }

    public User(int userid, String email, String password, int idNumber, String firstName, String lastName, Date dateOfBirth, Long phoneNumber, String address, LocalDate createdAt, String lastLogin, Account account, LoanPayment loanpayment, Beneficiary beneficiary, Message message, Notification notification) {
        this.userid = userid;
        this.email = email;
        this.password = password;
        this.idNumber = idNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.createdAt = createdAt;
        this.lastLogin = lastLogin;
        this.account = account;
        this.loanpayment = loanpayment;
        this.beneficiary = beneficiary;
        this.message = message;
        this.notification = notification;
    }

    public User (Builder builder) {
        this.userid = builder.userid;
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
        this.account = builder.account;
        this.loanpayment = builder.loanpayment;
        this.beneficiary = builder.beneficiary;
        this.message = builder.message;
        this.notification = builder.notification;




    }

    public int getUserid() {
        return userid;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public String getLastLogin() {
        return lastLogin;
    }

public Account getAccount() {
        return account;
}
public LoanPayment getLoanpayment() {
        return loanpayment;
}
public Beneficiary getBeneficiary() {
        return beneficiary;

}
public Message getMessage() {
        return message;
}
public Notification getNotification() {
        return notification;
}


    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
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
                ", account=" + account +
                ", loanpayment=" + loanpayment +
                ", beneficiary=" + beneficiary +
                ", message=" + message +
                ", notification=" + notification +
                '}';
    }

    public static class Builder {
        private int userid;
        private String email;
        private String password;
        private int idNumber;
        private String firstName;
        private String lastName;
        private Date dateOfBirth;
        private Long phoneNumber;
        private String address;
        private LocalDate createdAt;
        private String lastLogin;
        private Account account;

        private LoanPayment loanpayment;
        private Beneficiary beneficiary;
        private Message message;
        private Notification notification;



        public Builder setUserid(Integer userid){
            this.userid= userid;
            return this;
    }
    public Builder setEmail(String email){
            this.email = email;
            return this;
    }
    public Builder setPassword(String password){
            this.password = password;
            return this;
    }
    public Builder setIdNumber(Integer idNumber){
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
    public Builder setDateOfBirth(Date dateOfBirth){
            this.dateOfBirth = dateOfBirth;
            return this;
    }
    public Builder setPhoneNumber(Long phoneNumber){
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
    public Builder setLastLogin(String lastLogin){
            this.lastLogin = lastLogin;
            return this;
    }
   public Builder setAccount(Account account){
            this.account = account;
            return this;
   }
   public Builder setLoanpayment(LoanPayment loanpayment){
            this.loanpayment = loanpayment;
            return this;
   }
   public Builder setBeneficiary(Beneficiary beneficiary){
            this.beneficiary = beneficiary;
            return this;
   }
  public Builder setMessage(Message message){
            this.message = message;
            return this;
  }
  public Builder setNotification(Notification notification){
            this.notification = notification;
            return this;
  }

    public User build() {
            return new User(this);
    }
}

}
