package Home3;

import java.util.Scanner;

public class NumberInfo {
    private static String isEven(int number) {
        if (number % 2 == 0) {
            return "number " + number + " is even";
        } else {
            return "number " + number + " is not even";
        }
    }

    private static String isPrime(int number) {
        int delimeters = 0;
        for (int x = number - 1; x > 2; x--) {
            if (number % x == 0) {
                delimeters++;
            }
        }
        if (delimeters == 0) {
            return "number " + number + " is prime";
        } else {
            return "number " + number + " is not prime";
        }
    }

    private static String multiplies(int number) {
        String mult = "";
        for (int x = number; x > 0; x--) {
            if (number % x == 0) {
                mult +=  x + ", " ;
            }
        }
        return "Number " + number + " is a multiple of -> "+mult;
    }

    private static int getInt() {
        Scanner inScanner = new Scanner(System.in);
        int number = 0;
        do {
            try {
                number = Integer.parseInt(inScanner.next());
            } catch (NumberFormatException ex) {
                System.out.println("Error Try again.");
            }
        } while (number < 1);
        return number;
    }

    public static void main(String[] args) {
        System.out.println("enter number  ");
        int number = getInt();
        System.out.println(isEven(number));
        System.out.println(isPrime(number));
        System.out.println(multiplies(number));
    }
}
