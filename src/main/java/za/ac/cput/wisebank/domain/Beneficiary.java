package za.ac.cput.wisebank.domain;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Beneficiary {

    @Id
    private int beneficiaryId;

    private int userId;
    private String accountNumber;
    private String name;
    private String bankName;
    private LocalDate addedAt;

    protected Beneficiary() {} // required by JPA

    public Beneficiary(int beneficiaryId, int userId, String accountNumber, String name, String bankName, LocalDate addedAt) {
        this.beneficiaryId = beneficiaryId;
        this.userId = userId;
        this.accountNumber = accountNumber;
        this.name = name;
        this.bankName = bankName;
        this.addedAt = addedAt;
    }

    // Getters
    public int getBeneficiaryId() { return beneficiaryId; }
    public int getUserId() { return userId; }
    public String getAccountNumber() { return accountNumber; }
    public String getName() { return name; }
    public String getBankName() { return bankName; }
    public LocalDate getAddedAt() { return addedAt; }
}
