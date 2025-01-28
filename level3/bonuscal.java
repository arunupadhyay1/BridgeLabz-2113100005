import java.util.Random;

public class bonuscal {

    public static void main(String[] args) {
        int[][] employeeData = generateEmployeeData(10);
        double[][] updatedSalariesAndBonuses = calculateNewSalariesAndBonuses(employeeData);
        displayResults(employeeData, updatedSalariesAndBonuses);
    }

    public static int[][] generateEmployeeData(int numberOfEmployees) {
        Random random = new Random();
        int[][] employeeData = new int[numberOfEmployees][2];

        for (int i = 0; i < numberOfEmployees; i++) {
            employeeData[i][0] = 10000 + random.nextInt(90000);
            employeeData[i][1] = random.nextInt(11);
        }

        return employeeData;
    }

    public static double[][] calculateNewSalariesAndBonuses(int[][] employeeData) {
        double[][] updatedData = new double[employeeData.length][3];

        for (int i = 0; i < employeeData.length; i++) {
            int oldSalary = employeeData[i][0];
            int yearsOfService = employeeData[i][1];
            double bonus = (yearsOfService > 5) ? oldSalary * 0.05 : oldSalary * 0.02;
            double newSalary = oldSalary + bonus;

            updatedData[i][0] = oldSalary;
            updatedData[i][1] = newSalary;
            updatedData[i][2] = bonus;
        }

        return updatedData;
    }

    public static void displayResults(int[][] employeeData, double[][] updatedSalariesAndBonuses) {
        double totalOldSalary = 0;
        double totalNewSalary = 0;
        double totalBonus = 0;

        System.out.printf("%-10s %-15s %-15s %-15s\n", "Employee", "Old Salary", "New Salary", "Bonus");
        for (int i = 0; i < employeeData.length; i++) {
            int employeeNumber = i + 1;
            double oldSalary = updatedSalariesAndBonuses[i][0];
            double newSalary = updatedSalariesAndBonuses[i][1];
            double bonus = updatedSalariesAndBonuses[i][2];

            System.out.printf("%-10d %-15.2f %-15.2f %-15.2f\n", employeeNumber, oldSalary, newSalary, bonus);

            totalOldSalary += oldSalary;
            totalNewSalary += newSalary;
            totalBonus += bonus;
        }

        System.out.printf("\nTotal Old Salary: %.2f\n", totalOldSalary);
        System.out.printf("Total New Salary: %.2f\n", totalNewSalary);
        System.out.printf("Total Bonus Amount: %.2f\n", totalBonus);
    }
}
