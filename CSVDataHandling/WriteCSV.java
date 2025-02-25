import java.io.FileWriter;
import java.io.IOException;

public class WriteCSV {
    public static void main(String[] args) {
        String csvFile = "employees.csv";
        try (FileWriter writer = new FileWriter(csvFile)) {
            writer.append("ID,Name,Department,Salary\n");
            writer.append("1,John Doe,HR,50000\n");
            writer.append("2,Jane Smith,IT,60000\n");
            writer.append("3,Emily Johnson,Finance,55000\n");
            writer.append("4,Michael Brown,IT,70000\n");
            writer.append("5,Jessica Davis,Marketing,45000\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}