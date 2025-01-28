import java.util.Scanner;
public class Sumnaturalnumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a positive integer n: ");
        int n = scanner.nextInt();
        
        int sum = sumOfNaturalNumbers(n);
        System.out.println("The sum of the first " + n + " natural numbers is " + sum);
        
        scanner.close();
    }
    
    public static int sumOfNaturalNumbers(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }
}
