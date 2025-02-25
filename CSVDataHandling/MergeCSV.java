import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MergeCSV {
    public static void main(String[] args) {
        String file1 = "students1.csv";
        String file2 = "students2.csv";
        String outputFile = "merged_students.csv";
        Map<String, String[]> studentMap = new HashMap<>();
        String line;

        try (BufferedReader br1 = new BufferedReader(new FileReader(file1))) {
            while ((line = br1.readLine()) != null) {
                String[] data = line.split(",");
                studentMap.put(data[0], new String[]{data[1], data[2]});
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br2 = new BufferedReader(new FileReader(file2));
             FileWriter writer = new FileWriter(outputFile)) {
            writer.append("ID,Name,Age,Marks,Grade\n");
            while ((line = br2.readLine()) != null) {
                String[] data = line.split(",");
                String[] studentDetails = studentMap.get(data[0]);
                if (studentDetails != null) {
                    writer.append(String.join(",", data[0], studentDetails[0], studentDetails[1], data[1], data[2]) + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}