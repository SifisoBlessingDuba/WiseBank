package za.ac.cput.wisebank.domain;


import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;

import java.time.LocalDate;
import java.util.Date;

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
    @OneToMany
    @JoinColumn(name = "Account_Id")
    private Account account;


    public User(){

    }

    private User(int userid, String email, String password, int idNumber, String firstName, String lastName, Date dateOfBirth, Long phoneNumber,String address, LocalDate createdAt, String lastLogin) {
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
    }

    private User (Builder builder) {
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
                ", address=" + address +
                ", createdAt=" + createdAt +
                ", lastLogin='" + lastLogin + '\'' +
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
    public User build() {
            return new User(this);
    }
}

}
