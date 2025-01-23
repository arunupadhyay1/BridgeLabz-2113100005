import java.util.Scanner;

public class checkbmi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter weight in kg: ");
        double weight = scanner.nextDouble();

        System.out.print("Enter height in cm: ");
        double heightCm = scanner.nextDouble();

        double heightM = heightCm / 100; // Convert height from cm to meters
        double bmi = weight / (heightM * heightM); // Calculate BMI

        String weightStatus;

        if (bmi <= 18.4) {
            weightStatus = "Underweight";
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            weightStatus = "Normal";
        } else if (bmi >= 25.0 && bmi <= 39.9) {
            weightStatus = "Overweight";
        } else {
            weightStatus = "Obese";
        }

        System.out.printf("Your BMI is: %.2f\n", bmi);
        System.out.println("Weight Status: " + weightStatus);

        scanner.close();
    }
}