import java.util.Scanner;

public class Maximumhandshakes{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number of students: ");
        int numberOfStudents = scanner.nextInt();
        
        int handshakes = calculatehandshakes(numberOfStudents);
        System.out.println("The maximum number of handshakes is " + handshakes);
        
        scanner.close();
    }
    
    public static int calculatehandshakes(int n) {
        return (n * (n - 1)) / 2;
    }
}
