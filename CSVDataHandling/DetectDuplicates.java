import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class DetectDuplicates {
    public static void main(String[] args) {
        String csvFile = "data.csv";
        String line;
        Set<String> ids = new HashSet<>();
        Set<String> duplicates = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (!ids.add(data[0])) {
                    duplicates.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String duplicate : duplicates) {
            System.out.println("Duplicate record: " + duplicate);
        }
    }
}