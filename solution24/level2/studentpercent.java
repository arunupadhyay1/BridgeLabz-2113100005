import java.util.Scanner;

public class studentpercent {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();

        int[][] marks = new int[n][3];
        double[] percentages = new double[n];
        char[] grades = new char[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nStudent " + (i + 1) + ":");

            for (int j = 0; j < 3; j++) {
                String subject = (j == 0) ? "Physics" : (j == 1) ? "Chemistry" : "Maths";
                do {
                    System.out.print("Enter marks in " + subject + " (0-100): ");
                    marks[i][j] = scanner.nextInt();
                    if (marks[i][j] < 0 || marks[i][j] > 100) {
                        System.out.println("Invalid marks. Please enter a value between 0 and 100.");
                    }
                } while (marks[i][j] < 0 || marks[i][j] > 100);
            }

            percentages[i] = (marks[i][0] + marks[i][1] + marks[i][2]) / 3.0;

            if (percentages[i] >= 80) {
                grades[i] = 'A';
            } else if (percentages[i] >= 70) {
                grades[i] = 'B';
            } else if (percentages[i] >= 60) {
                grades[i] = 'C';
            } else if (percentages[i] >= 50) {
                grades[i] = 'D';
            } else if (percentages[i] >= 40) {
                grades[i] = 'E';
            } else {
                grades[i] = 'F';
            }
        }

        System.out.println("\nResults:");
        System.out.printf("%-10s %-10s %-10s %-10s %-15s %-10s\n", "Physics", "Chemistry", "Maths", "Percentage", "Grade", "Remarks");
        for (int i = 0; i < n; i++) {
            String remarks;
            switch (grades[i]) {
                case 'A':
                    remarks = "Level 4, above agency-normalized standards";
                    break;
                case 'B':
                    remarks = "Level 3, at agency-normalized standards";
                    break;
                case 'C':
                    remarks = "Level 2, below, but approaching agency-normalized standards";
                    break;
                case 'D':
                    remarks = "Level 1, well below agency-normalized standards";
                    break;
                case 'E':
                    remarks = "Level 1-, too below agency-normalized standards";
                    break;
                default:
                    remarks = "Remedial standards";
            }

            System.out.printf("%-10d %-10d %-10d %-10.2f %-15c %-10s\n", marks[i][0], marks[i][1], marks[i][2], percentages[i], grades[i], remarks);
        }

        scanner.close();
    }
}