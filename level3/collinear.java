import java.util.Scanner;

public class collinear {

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
        System.out.print("Enter x3: ");
        double x3 = scanner.nextDouble();
        System.out.print("Enter y3: ");
        double y3 = scanner.nextDouble();
        
        boolean areCollinearBySlope = areCollinearBySlope(x1, y1, x2, y2, x3, y3);
        boolean areCollinearByArea = areCollinearByArea(x1, y1, x2, y2, x3, y3);
        
        if (areCollinearBySlope) {
            System.out.println("The points are collinear (using slope method).");
        } else {
            System.out.println("The points are not collinear (using slope method).");
        }
        
        if (areCollinearByArea) {
            System.out.println("The points are collinear (using area method).");
        } else {
            System.out.println("The points are not collinear (using area method).");
        }
        
        scanner.close();
    }

    public static boolean areCollinearBySlope(double x1, double y1, double x2, double y2, double x3, double y3) {
        double slopeAB = (y2 - y1) / (x2 - x1);
        double slopeBC = (y3 - y2) / (x3 - x2);
        double slopeAC = (y3 - y1) / (x3 - x1);
        
        return (slopeAB == slopeBC) && (slopeAB == slopeAC);
    }

    public static boolean areCollinearByArea(double x1, double y1, double x2, double y2, double x3, double y3) {
        double area = 0.5 * (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
        return area == 0;
    }
}
