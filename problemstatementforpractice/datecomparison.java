import java.time.LocalDate;
import java.util.Scanner;

public class datecomparison {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first date (yyyy-mm-dd):");
        String firstDateInput = sc.nextLine();
        System.out.println("Enter the second date (yyyy-mm-dd):");
        String secondDateInput = sc.nextLine();
        
        LocalDate firstDate = LocalDate.parse(firstDateInput);
        LocalDate secondDate = LocalDate.parse(secondDateInput);
        
        if (firstDate.isBefore(secondDate)) {
            System.out.println("The first date is before the second date.");
        } else if (firstDate.isAfter(secondDate)) {
            System.out.println("The first date is after the second date.");
        } else {
            System.out.println("The first date is the same as the second date.");
        }
        
        sc.close();
    }
}