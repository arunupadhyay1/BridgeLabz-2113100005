import java.util.Scanner;

public class bonus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the employee's salary: ");
        double salary = scanner.nextDouble();
        
        System.out.print("Enter the years of service: ");
        int yearsOfservice = scanner.nextInt();
        
        double bonus = 0.0;
        
        if (yearsOfservice > 5) {
            bonus = salary * 0.05; // 5% bonus
        }
        
        System.out.println("The bonus amount is: " + bonus);
        
        scanner.close();
    }
}