package za.ac.cput.wisebank.dto;

import java.time.LocalDateTime;

public class WithdrawalResponse {
    private String accountNumber;
    private double withdrawnAmount;
    private double newBalance;
    private String status;
    private LocalDateTime timestamp;

    public WithdrawalResponse(String accountNumber, double withdrawnAmount, double newBalance, String status, LocalDateTime timestamp) {
        this.accountNumber = accountNumber;
        this.withdrawnAmount = withdrawnAmount;
        this.newBalance = newBalance;
        this.status = status;
        this.timestamp = timestamp;
    }

    // Getters only (immutable response)
    public String getAccountNumber() { return accountNumber; }
    public double getWithdrawnAmount() { return withdrawnAmount; }
    public double getNewBalance() { return newBalance; }
    public String getStatus() { return status; }
    public LocalDateTime getTimestamp() { return timestamp; }
}
