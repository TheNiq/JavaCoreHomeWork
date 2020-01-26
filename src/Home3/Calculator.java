package Home3;


import java.util.Scanner;

public class Calculator {
    private static Scanner scanner = new Scanner(System.in);

    private static double getDouble() {
        System.out.println("Enter Numbers");
        double num = 0;
        boolean flag = true;
        while(flag){
            if (scanner.hasNextDouble()) {
                num = scanner.nextDouble();
                flag = false;
            }
            else {
                System.out.println("Error");
                scanner.next();

            }
        }
        return num;
    }

    private static char getOperations() {
        System.out.println("ENTER operations");
        char[] array = {47,42,43,45};
        char operation = 0;
        boolean flag = true;
        while (flag){
            if (scanner.hasNext()) {
                operation = scanner.next().charAt(0);
                if(operation == array[0] || operation == array[1] || operation == array[2] || operation == array[3] ){
                    flag = false;
                    return operation;
                }
                else {
                    System.out.println("вы ввели не правильный символ ");
                }

            } else {
                System.out.println("Error ");
            }
        }
        return operation;
    }
    private static double getResult(double num1, double num2, char operation){
        double result = 0;
        boolean flag = true;
        while (flag )
            switch (operation){
                case '+':
                    result = num1 + num2;
                    flag = false;
                    break;
                case '-':
                    result = num1 - num2;
                    flag = false;
                    break;
                case '*':
                    result = num1 * num2;
                    flag = false;
                    break;
                case '/':
                    if(num2 == 0){
                        System.out.println("Error cannot be divided by 0" );
                        flag =false;
                        break;
                    }
                    if(num1 > 0){
                        result = num1 / num2;
                        flag = false;
                        break;
                    }

                default:
                    System.out.println("rewr");
            }
        return result;
    }



    public static void main(String[] args) {
        double num1 = getDouble();
        double num2 = getDouble();
        char opertion = getOperations();
        double result = getResult(num1, num2, opertion );
        System.out.println(result);



    }
}