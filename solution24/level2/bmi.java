import java.util.Scanner;

public class bmi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of persons: ");
        int number = scanner.nextInt();
        double[] weights = new double[number];
        double[] heights = new double[number];
        double[] bmi = new double[number];
        String[] weightStatus = new String[number];
        for (int i = 0; i < number; i++) {
            while (true) {
                System.out.print("Enter weight for person " + (i + 1) + ": ");
                weights[i] = scanner.nextDouble();
                System.out.print("Enter height for person " + (i + 1) + ": ");
                heights[i] = scanner.nextDouble();
                if (weights[i] > 0 && heights[i] > 0) break;
            }
            bmi[i] = weights[i] / (heights[i] * heights[i]);
            if (bmi[i] < 18.5) weightStatus[i] = "Underweight";
            else if (bmi[i] < 24.9) weightStatus[i] = "Normal weight";
            else if (bmi[i] < 29.9) weightStatus[i] = "Overweight";
            else weightStatus[i] = "Obesity";
        }
        for (int i = 0; i < number; i++) {
            System.out.println("Person " + (i + 1) + ": Height = " + heights[i] + ", Weight = " + weights[i] + ", BMI = " + bmi[i] + ", Status = " + weightStatus[i]);
        }
    }
}