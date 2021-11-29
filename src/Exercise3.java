import java.util.Scanner;

public class Exercise3 {
    public static final int AFTER_PREFIX_OPTION1 = 2, ONLY_NUMBERS = 1,
            AFTER_PREFIX_OPTION2 = 3, NUMBERS_AND_LINE = 0,
            AFTER_PREFIX_OPTION3 = 4;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter phone number please: ");
        String phoneNumber = scanner.nextLine();
        System.out.println(normalizePhoneNumber(phoneNumber));
    }

    public static String normalizePhoneNumber(String phoneNumber) {
        boolean option1 = false;
        boolean option2 = false;
        boolean option3 = false;
        char[] normalizedNumber;
        if ((phoneNumber.charAt(0) == '0' && phoneNumber.charAt(1) == '5')) {
            if (phoneNumber.length() == 10) {
                option1 = sortOptions(AFTER_PREFIX_OPTION1, ONLY_NUMBERS, phoneNumber);
            }
            if ((phoneNumber.length() == 11) && (phoneNumber.charAt(3) == '-')) {
                option2 = sortOptions(AFTER_PREFIX_OPTION2, NUMBERS_AND_LINE, phoneNumber);
            }
        }
        if ((phoneNumber.length() == 12) && (phoneNumber.charAt(0) == '9' && phoneNumber.charAt(1) == '7' && phoneNumber.charAt(2) == '2' && phoneNumber.charAt(3) == '5')) {
            option3 = sortOptions(AFTER_PREFIX_OPTION3, ONLY_NUMBERS, phoneNumber);
        }
        if (option1 == true) {
            normalizedNumber = new char[phoneNumber.length() + 1];
            for (int i = 0, j = 0; i < normalizedNumber.length; i++, j++) {
                if (i == 3) {
                    normalizedNumber[i] = '-';
                    j--;
                } else {
                    normalizedNumber[i] = phoneNumber.charAt(j);
                }
            }
            phoneNumber = new String(normalizedNumber);
            return phoneNumber;

        }
        if (option2 == true) {
            return phoneNumber;
        }
        if (option3 == true) {
            normalizedNumber = new char[phoneNumber.length() - 1];
            for (int i = 0, j = 0; i < normalizedNumber.length; i++, j++) {
                if (i == 0) {
                    normalizedNumber[i] = '0';
                } else if (i == 1) {
                    normalizedNumber[i] = '5';
                } else if (i == 2) {
                    normalizedNumber[i] = phoneNumber.charAt(4);
                } else if (i == 3) {
                    normalizedNumber[i] = '-';
                    j++;
                } else {
                    normalizedNumber[i] = phoneNumber.charAt(j);
                }
            }
            phoneNumber = new String(normalizedNumber);
            return phoneNumber;
        }
        if (option1 == false && option2 == false && option3 == false) {
            phoneNumber = " ";
        }
        return phoneNumber;
    }

    public static boolean sortOptions(int indexI, int indexJ, String phoneNumber) {
        boolean option = false;
        String digitsAndLine = "-0123456789";
        for (int i = indexI; i < phoneNumber.length(); i++) {
            for (int j = indexJ; j < digitsAndLine.length(); j++) {
                if (phoneNumber.charAt(i) == digitsAndLine.charAt(j)) {
                    option = true;
                    break;
                } else if ((phoneNumber.charAt(i) != digitsAndLine.charAt(j)) && (j == digitsAndLine.length() - 1)) {
                    option = false;
                    return option;
                }
            }
        }
        return option;
    }
}