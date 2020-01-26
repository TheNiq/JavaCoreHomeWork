package Home3;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class AverageManyNumbers {
    public static Scanner inScanner = new Scanner(System.in);

    public static void main(String[] args) {
        BigDecimal sum = new BigDecimal(0);
        int numbersCounter = 0;
        String str = "";
        System.out.println("enter 'exit' to exit " );
        do {
            str = inScanner.next();
            if (!str.equals("exit")) {
                BigDecimal enteredNumber = new BigDecimal(str);
                sum = sum.add(enteredNumber);
                numbersCounter++;

            }
        } while (!str.equals("exit"));

        if (numbersCounter > 0) {
            System.out.println("average -> " + sum.divide(new BigDecimal(numbersCounter), 2, RoundingMode.HALF_UP));
        } else {
            System.out.println("I have no suitable numbers!");
        }
    }
}
