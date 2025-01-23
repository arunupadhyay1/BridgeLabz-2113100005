import java.util.Scanner;

public class primenumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number greater than 1: ");
        int number = scanner.nextInt();
        
        boolean isPrime = true; // Assume the number is prime until proven otherwise
        
        if (number <= 1) {
            System.out.println("Please enter a number greater than 1.");
        } else {
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    isPrime = false; // The number is divisible by i, so it's not prime
                    break; // Exit the loop as we found a divisor
                }
            }
            
            if (isPrime) {
                System.out.println(number + " is a prime number.");
            } else {
                System.out.println(number + " is not a prime number.");
            }
        }
        
        scanner.close();
    }
}