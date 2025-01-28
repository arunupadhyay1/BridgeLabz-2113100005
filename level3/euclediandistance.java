import java.util.Scanner;

public class euclediandistance {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter x1: ");
        double x1 = scanner.nextDouble();
        System.out.print("Enter y1: ");
        double y1 = scanner.nextDouble();
        System.out.print("Enter x2: ");
        double x2 = scanner.nextDouble();
        System.out.print("Enter y2: ");
        double y2 = scanner.nextDouble();
        
        double distance = calculateEuclideanDistance(x1, y1, x2, y2);
        double[] lineEquation = findLineEquation(x1, y1, x2, y2);
        
        System.out.printf("Euclidean Distance: %.2f\n", distance);
        System.out.printf("Equation of the line: y = %.2fx + %.2f\n", lineEquation[0], lineEquation[1]);
        
        scanner.close();
    }

    public static double calculateEuclideanDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public static double[] findLineEquation(double x1, double y1, double x2, double y2) {
        double[] lineEquation = new double[2];
        double m = (y2 - y1) / (x2 - x1);
        double b = y1 - m * x1;
        lineEquation[0] = m; // slope
        lineEquation[1] = b; // y-intercept
        return lineEquation;
    }
}
