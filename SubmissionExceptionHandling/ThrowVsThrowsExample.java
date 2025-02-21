import java.util.Scanner;
public class ThrowVsThrowsExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter amount: ");
            double amount = scanner.nextDouble();
            System.out.print("Enter rate: ");
            double rate = scanner.nextDouble();
            System.out.print("Enter years: ");
            int years = scanner.nextInt();
            double interest = InterestCalculator.calculateInterest(amount, rate, years);
            System.out.println("Calculated interest: " + interest);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

class InterestCalculator {
    public static double calculateInterest(double amount, double rate, int years) {
        if (amount < 0 || rate < 0) {
            throw new IllegalArgumentException("Invalid input: Amount and rate must be positive");
        }
        return (amount * rate * years) / 100;
    }
}

