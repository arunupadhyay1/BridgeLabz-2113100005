import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SearchRecord {
    public static void main(String[] args) {
        String csvFile = "employees.csv";
        String line;
        String searchName = "Jane Smith";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data[1].equals(searchName)) {
                    System.out.printf("Department: %s, Salary: %s%n", data[2], data[3]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}