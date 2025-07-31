package za.ac.cput.wisebank.Factory;

import za.ac.cput.wisebank.domain.Transaction;
import za.ac.cput.wisebank.util.Helper;

import java.time.LocalDate;

public class TransactionFactory {
    public static Transaction createTransaction(Integer senderAccountId, Integer receiverAccountId,
                                                double amount, String status, String description, LocalDate transactionDate,
                                                String transactionType) {
        if(!Helper.isValidInteger(senderAccountId) ||
                !Helper.isValidInteger(receiverAccountId) ||
                !Helper.isValidDouble(amount) ||
                Helper.isNullOrEmpty(status) ||
                Helper.isNullOrEmpty(description) ||
                Helper.isNullOrEmpty(transactionType)){
            return null;
        }
        return new Transaction.Builder()
                .setSenderAccountId(senderAccountId)
                .setReceiverAccountId(receiverAccountId)
                .setAmount(amount)
                .setStatus(status)
                .setDescription(description)
                .setTransactionDate(transactionDate)
                .setTransactionType(transactionType)
                .build();
    }
}
