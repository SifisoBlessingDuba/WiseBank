package za.ac.cput.wisebank.domain;
import jakarta.persistence.*;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAlias;

@Entity
public class User {

    @Id
    @Column(name = "user_id")
    private String idNumber;
    private String email;
    @JsonIgnore
    private String password;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String phoneNumber;
    private String address;
    private LocalDate createdAt;
    private LocalDate lastLogin;

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
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    // Add setter to allow password updates (encoded by service layer)
    public void setPassword(String password) {
        this.password = password;
    }

    // Expose idNumber as JSON property "userId" so client payloads with userId map correctly
    @JsonProperty("userId")
    @JsonAlias({"idNumber"})
    public String getIdNumber() {
        return idNumber;
    }

    // Setter to allow Jackson to bind numeric or string userId values into the String idNumber
    @JsonProperty("userId")
    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
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
                '}';
    }

    public static class Builder {
        private String email;
        private String password;
        private String idNumber;
        private String firstName;
        private String lastName;
        private LocalDate dateOfBirth;
        private String phoneNumber;
        private String address;
        private LocalDate createdAt;
        private LocalDate lastLogin;

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

    public User build()  {
            return new User(this);
    }
}

}
//guys check if this page will show up in the final project
//24
