import java.util.*;
public class QuotientAndRemainder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first number:");
        double number1 = scanner.nextDouble();
        System.out.println("Enter the second number:");
        double number2 = scanner.nextDouble();
        double quotient = number1 / number2;
        double remainder = number1 % number2;
        System.out.println("The Quotient is " + quotient + " and Remainder is " + remainder);
        scanner.close();
    }
}