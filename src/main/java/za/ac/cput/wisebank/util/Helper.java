package za.ac.cput.wisebank.util;

public class Helper {
    public static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    // Todo: isValidPostalCode method - 4 digits with range 1000 to 9999
    public static boolean isValidShort(short postalCode) {
        if (postalCode < 1000 || postalCode > 9999) {
            return false;
        }
        return true;
    }

    // Todo: isValidErfNumber method - 1 to 5 digits with range 1 to 99999
    public static boolean isValidInt(int value) {
        if (value < 1 || value > 99999) {
            return false;
        }
        return true;
    }

    public static boolean isValidLong(Long accountNumber) {
        return false;
    }

    public static boolean isValidDouble(double accountBalance) {
        return false;
    }
}
