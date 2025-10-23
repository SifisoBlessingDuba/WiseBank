package za.ac.cput.wisebank.util;

public class Helper {
    public static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    // Todo: isValidShort method - 4 digits with range 1000 to 9999
    public static boolean isValidShort(short value) {
        if (value < 1000 || value > 9999) {
            return false;
        }
        return true;
    }

    // Todo: isValidInteger method - 1 to 5 digits with range 1 to 99999
    public static boolean isValidInt(int value) {
        if (value < 1 || value > 99999) {
            return false;
        }
        return true;
    }


    public static boolean isValidLong(Long accountNumber) {
        return false;
    }

    public static boolean isValidBoolean(Boolean value) {
        return value != null;
   }
    public static boolean isValidDouble(double value) {
        return value >= 0.0 && value <= 100000.0;
    }

    public static boolean isValidInteger(Integer value) {
        return value != null && value >= 1 && value <= 99999;

    }
}
// //guys check if this page will show up in the final project
//75
