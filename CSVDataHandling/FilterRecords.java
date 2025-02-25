import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilterRecords {
    public static void main(String[] args) {
        String csvFile = "students.csv";
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (Integer.parseInt(data[3]) > 80) {
                    System.out.printf("ID: %s, Name: %s, Age: %s, Marks: %s%n", data[0], data[1], data[2], data[3]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}