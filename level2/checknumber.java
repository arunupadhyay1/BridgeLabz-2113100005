import java.util.Scanner;

public class checknumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int[] numbers = new int[5];
        
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
            if (isPositive(numbers[i])) {
                System.out.println(numbers[i] + " is positive.");
                if (isEven(numbers[i])) {
                    System.out.println(numbers[i] + " is even.");
                } else {
                    System.out.println(numbers[i] + " is odd.");
                }
            } else {
                System.out.println(numbers[i] + " is negative.");
            }
        }
        
        int comparisonResult = compare(numbers[0], numbers[numbers.length - 1]);
        if (comparisonResult > 0) {
            System.out.println("The first number is greater than the last number.");
        } else if (comparisonResult < 0) {
            System.out.println("The first number is less than the last number.");
        } else {
            System.out.println("The first number is equal to the last number.");
        }
 scanner.close();
    }
    
    public static boolean isPositive(int number) {
        return number >= 0;
    }
    
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
    
    public static int compare(int number1, int number2) {
        if (number1 > number2) {
            return 1;
        } else if (number1 < number2) {
            return -1;
        } else {
            return 0;
        }
    }
}
