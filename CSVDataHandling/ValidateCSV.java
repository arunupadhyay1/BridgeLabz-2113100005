import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class ValidateCSV {
    public static void main(String[] args) {
        String csvFile = "data.csv";
        String line;
        Pattern emailPattern = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
        Pattern phonePattern = Pattern.compile("^\\d{10}$");
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (!emailPattern.matcher(data[2]).matches() || !phonePattern.matcher(data[3]).matches()) {
                    System.out.printf("Invalid row: %s%n", line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}