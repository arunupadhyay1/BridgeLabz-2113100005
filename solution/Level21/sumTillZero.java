import java.util.Scanner;

public class sumTillZero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        double total = 0.0;
        double userInput;

        System.out.println("Enter numbers to sum them up (enter 0 to finish):");
        
        while (true) {
            userInput = scanner.nextDouble();
            
            if (userInput == 0) {
                break; // Exit the loop if the user enters 0
            }
            
            total += userInput; // Add the user input to the total
        }
        
        System.out.println("The total sum is: " + total);
        scanner.close();
    }
}