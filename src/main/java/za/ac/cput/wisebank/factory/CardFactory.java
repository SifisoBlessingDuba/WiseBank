package za.ac.cput.wisebank.factory;

import za.ac.cput.wisebank.domain.Card;
import za.ac.cput.wisebank.util.Helper;

import java.time.LocalDate;

public class CardFactory {
    public static Card createCard(String cardNumber, String cardType, Boolean status, double cardLimit, int cvv, LocalDate expiryDate, LocalDate issuedDate){

        if(Helper.isNullOrEmpty(cardNumber) ||
                Helper.isNullOrEmpty(cardType) ||
                !Helper.isValidBoolean(status) ||
                !Helper.isValidDouble(cardLimit) ||
                !Helper.isValidInt(cvv)
        ) {
            return null;
        }

        return new Card.Builder()
                .setCardNumber(cardNumber)
                .setCardType(cardType)
                .setStatus(status)
                .setCardLimit(cardLimit)
                .setCvv(cvv)
                .setExpiryDate(expiryDate)
                .setIssuedDate(issuedDate)
                .build();
    }
}
