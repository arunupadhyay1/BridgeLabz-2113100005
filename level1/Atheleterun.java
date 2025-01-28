	import java.util.Scanner;

public class Atheleterun {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the three sides of the triangle: ");
        double side1 = scanner.nextDouble();
        double side2 = scanner.nextDouble();
        double side3 = scanner.nextDouble();
        
        int rounds = calculaterounds(side1, side2, side3);
        System.out.println("The number of rounds to complete a 5 km run is " + rounds);
        
        scanner.close();
    }
    
    public static int calculaterounds(double side1, double side2, double side3) {
        double perimeter = side1 + side2 + side3;
        double distance = 5000; // 5 km in meters
        return (int) Math.ceil(distance / perimeter);
    }
}
