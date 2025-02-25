import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadLargeCSV {
    public static void main(String[] args) {
        String csvFile = "large_data.csv";
        String line;
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                count++;
                if (count % 100 == 0) {
                    System.out.println("Processed " + count + " records.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Total records processed: " + count);
    }
}