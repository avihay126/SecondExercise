import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first string");
        String str1 = scanner.nextLine();
        System.out.println("Enter second string");
        String str2 = scanner.nextLine();
        System.out.println(isTheStringContained(str1, str2));
    }

    public static boolean isTheStringContained(String str1, String str2) {
        if (str2.length() <= str1.length()) {
            int i = 0;
            for (int j = 0; j < str1.length(); j++) {
                while (str1.charAt(j) == str2.charAt(i)) {
                    i++;
                    j++;
                    if (i == str2.length()) {
                        return true;
                    }
                    if (j == str1.length()) {
                        break;
                    }
                    if (str1.charAt(j) != str2.charAt(i)) {
                        i = 0;
                    }
                }
            }
        }
        return false;
    }
}