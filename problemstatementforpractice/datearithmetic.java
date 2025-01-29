import java.time.LocalDate;
import java.util.Scanner;

public class datearithmetic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a date (yyyy-mm-dd):");
        String inputDate = sc.nextLine();
        LocalDate date = LocalDate.parse(inputDate);
        date = date.plusDays(7).plusMonths(1).plusYears(2).minusWeeks(3);
        System.out.println("Resulting date: " + date);
        sc.close();
    }
}

