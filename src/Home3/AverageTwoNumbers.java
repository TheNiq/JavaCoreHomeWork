package Home3;

import java.math.BigDecimal;
import java.util.Scanner;

public class AverageTwoNumbers {
    public static Scanner inScanner = new Scanner(System.in);

    private static BigDecimal numberGet(String message) {
        String string = "";
        do {
            System.out.println(message);
            string = inScanner.next();
        } while (!isValid(string));
        return new BigDecimal(string);
    }

    private static boolean isValid(String enteredNumber) {
        try {
            BigDecimal.valueOf(Double.parseDouble(enteredNumber));
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public static void main(String[] args) {
        BigDecimal firstNumber = numberGet("first number -> ");
        BigDecimal secondNumber = numberGet("input second number -> ");
        System.out.println("average -> " + ((firstNumber.add(secondNumber)).divide(new BigDecimal(2))));
    }
}
