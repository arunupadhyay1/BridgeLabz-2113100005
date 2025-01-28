import java.util.Scanner;

public class Numbercheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        
        int result = checknumber(number);
        System.out.println("The number is " + result);
        
        scanner.close();
    }
    
    public static int checknumber(int number) {
        if (number < 0) {
            return -1;
        } else if (number > 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
