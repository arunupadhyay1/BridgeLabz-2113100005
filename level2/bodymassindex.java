import java.util.Scanner;

public class bodymassindex {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] data = new double[10][3]; // 10 rows, 3 columns (weight, height, BMI)
        
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter weight (in kg) for person " + (i + 1) + ": ");
            data[i][0] = scanner.nextDouble();
            System.out.print("Enter height (in cm) for person " + (i + 1) + ": ");
            data[i][1] = scanner.nextDouble();
        }
        
        calculateBMI(data);
        String[] status = determineBMIStatus(data);
        
        System.out.println("\nBMI Report:");
        System.out.printf("%-10s %-10s %-10s %-15s\n", "Weight", "Height", "BMI", "Status");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%-10.2f %-10.2f %-10.2f %-15s\n", data[i][0], data[i][1], data[i][2], status[i]);
        }
        
        scanner.close();
    }
    
    public static void calculateBMI(double[][] data) {
        for (int i = 0; i < data.length; i++) {
            double heightInMeters = data[i][1] / 100; // Convert height from cm to meters
            data[i][2] = data[i][0] / (heightInMeters * heightInMeters); // BMI calculation
        }
    }
 public static String[] determineBMIStatus(double[][] data) {
        String[] status = new String[10];
        for (int i = 0; i < data.length; i++) {
            if (data[i][2] < 18.5) {
                status[i] = "Underweight";
            } else if (data[i][2] >= 18.5 && data[i][2] < 25.0) {
                status[i] = "Normal";
            } else if (data[i][2] >= 25.0 && data[i][2] < 40.0) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }
        return status;
    }
}
