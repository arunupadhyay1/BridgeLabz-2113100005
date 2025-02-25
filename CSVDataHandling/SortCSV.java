import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortCSV {
    public static void main(String[] args) {
        String csvFile = "employees.csv";
        String line;
        List<String[]> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                records.add(line.split(","));
            }
            records.sort(Comparator.comparingDouble(record -> Double.parseDouble(record[3])).reversed());
            for (int i = 0; i < 5 && i < records.size(); i++) {
                System.out.printf("ID: %s, Name: %s, Department: %s, Salary: %s%n", records.get(i)[0], records.get(i)[1], records.get(i)[2], records.get(i)[3]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}