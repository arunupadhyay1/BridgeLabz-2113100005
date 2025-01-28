import java.util.Scanner;

public class Quadratic {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter coefficient a: ");
        double a = scanner.nextDouble();
        System.out.print("Enter coefficient b: ");
        double b = scanner.nextDouble();
        System.out.print("Enter coefficient c: ");
        double c = scanner.nextDouble();
        
        double[] roots = findRoots(a, b, c);
        
        if (roots.length == 0) {
            System.out.println("The equation has no real roots.");
        } else if (roots.length == 1) {
            System.out.printf("The equation has one root: x = %.2f\n", roots[0]);
        } else {
            System.out.printf("The equation has two roots: x1 = %.2f, x2 = %.2f\n", roots[0], roots[1]);
        }
        
        scanner.close();
    }
 public static double[] findRoots(double a, double b, double c) {
        double delta = Math.pow(b, 2) - 4 * a * c;
        
        if (delta < 0) {
            return new double[0]; // No real roots
        } else if (delta == 0) {
            double root = -b / (2 * a);
            return new double[] { root }; // One root
        } else {
            double root1 = (-b + Math.sqrt(delta)) / (2 * a);
            double root2 = (-b - Math.sqrt(delta)) / (2 * a);
            return new double[] { root1, root2 }; // Two roots
        }
    }
}
