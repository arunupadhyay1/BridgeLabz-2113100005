import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ModifyCSV {
    public static void main(String[] args) {
        String inputFile = "employees.csv";
        String outputFile = "updated_employees.csv";
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             FileWriter writer = new FileWriter(outputFile)) {
            writer.append("ID,Name,Department,Salary\n");
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data[2].equals("IT")) {
                    double newSalary = Double.parseDouble(data[3]) * 1.1;
                    writer.append(String.join(",", data[0], data[1], data[2], String.valueOf(newSalary)) + "\n");
                } else {
                    writer.append(line + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}