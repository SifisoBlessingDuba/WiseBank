package za.ac.cput.wisebank.dto;

import za.ac.cput.wisebank.domain.User;

import java.time.LocalDate;

public class UserDTO {
    private String userId; // mapped from idNumber
    private String email;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String phoneNumber;
    private String address;
    private LocalDate createdAt;
    private LocalDate lastLogin;

    public static UserDTO from(User user) {
        UserDTO dto = new UserDTO();
        dto.userId = user.getIdNumber();
        dto.email = user.getEmail();
        dto.firstName = user.getFirstName();
        dto.lastName = user.getLastName();
        dto.dateOfBirth = user.getDateOfBirth();
        dto.phoneNumber = user.getPhoneNumber();
        dto.address = user.getAddress();
        dto.createdAt = user.getCreatedAt();
        dto.lastLogin = user.getLastLogin();
        return dto;
    }

    public String getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
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
}

