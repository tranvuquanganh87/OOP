package utilities;

import code.Item;
import code.VideoStore;

public class ErrorHandle {
    public static int MIN_CHAR = 1;
    public static int MAX_CHAR = 201;
    public static int MAX_NUM = 10;
    public static boolean customerNameValidate(String name) {
        if ((name.length() < MIN_CHAR) || (name.length() > MAX_CHAR)) {
            return false;
        }

        for (int i = 0; i < name.length(); i++) {
            if (Character.isSpaceChar(name.charAt(i)))
                continue;

            if (!Character.isLetter(name.charAt(i)))
                return false;
        }
        return true;
    }

    public static boolean customerAddressValidate(String address) {
        if ((address.length() < MIN_CHAR) || (address.length() > MAX_CHAR)) {
            return false;
        }

        for (int i = 0; i < address.length(); i++) {
            if (Character.isSpaceChar(address.charAt(i)))
                continue;

            if (!Character.isLetterOrDigit(address.charAt(i)))
                return false;
        }
        return true;
    }

    public static boolean customerPhoneNumberValidate(String phoneNumber) {
        if ((phoneNumber.length() < MIN_CHAR) || (phoneNumber.length() > MAX_NUM)) {
            return false;
        }

        for (int i = 0; i < phoneNumber.length(); i++) {
            if (!Character.isDigit(phoneNumber.charAt(i)))
                return false;
        }
        return true;
    }
    public static boolean customerUsernameValidate(String username) {
        if ((username.length() < MIN_CHAR) || (username.length() > MAX_CHAR)) {
            return false;
        }

        for (int i = 0; i < username.length(); i++) {
            if (!Character.isLetterOrDigit(username.charAt(i)))
                return false;
        }
        return true;
    }
    public static boolean customerPasswordValidate(String pwd) {
        if ((pwd.length() < 8) || (pwd.length() > MAX_CHAR)) {
            return false;
        }

        for (int i = 0; i < pwd.length(); i++) {
            if (!Character.isLetterOrDigit(pwd.charAt(i)))
                return false;
        }
        return true;
    }
    public static boolean rentAmountValidate(Item item, String amount) {
        // Try catch for parseInt (if the input contains alphabetical letter)
        try {
            int num = Integer.parseInt(amount);
            if (num < 0 || num > item.getNumberOfCopies()) {
                System.out.println("Number of copies entered is invalid!");
                return false;
            } else {
                return true;
            }
        }catch (NumberFormatException e) {
            System.out.println("Please enter a numeric value!");
            return false;
        }
    }
}
