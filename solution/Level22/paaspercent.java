import java.util.Scanner;

public class paaspercent{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter marks for Physics: ");
        int physicsMarks = sc.nextInt();

        System.out.print("Enter marks for Chemistry: ");
        int chemistryMarks = sc.nextInt();

        System.out.print("Enter marks for Maths: ");
        int mathsMarks = sc.nextInt();

        int totalMarks = physicsMarks + chemistryMarks + mathsMarks;
        double averageMarks = totalMarks / 3.0;
        double percentage = (totalMarks / 300.0) * 100;

        char grade;
        String remark;

        if (percentage >= 80) {
            grade = 'A';
            remark = "Level 4,above agency-normalized standards";
        } else if (percentage >= 70) {
            grade = 'B';
            remark = "Level 3,at agency-normalized standards";
        } else if (percentage >= 60) {
            grade = 'C';
            remark = "Level 2,below, but approaching agency-normalized standards";
        } else if (percentage >= 50) {
            grade = 'D';
            remark = "well below agency-normalized standards";
        } else if (percentage >= 40) {
            grade = 'E';
            remark = "too below agency-normalized standards";
        } else {
            grade = 'R';
            remark = "Remedial standards";
        }

        System.out.printf("Total Marks: %d\n", totalMarks);
        System.out.printf("Average Marks: %.2f\n", averageMarks);
        System.out.printf("Percentage: %.2f%%\n", percentage);
        System.out.printf("Grade: %c\n", grade);
        System.out.println("Remarks: " + remark);

        sc.close();
    }
}