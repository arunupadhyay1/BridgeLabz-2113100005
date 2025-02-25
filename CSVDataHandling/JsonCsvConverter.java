import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

public class JsonCsvConverter {
    public static void jsonToCsv(String jsonFile, String csvFile) {
        try (FileWriter writer = new FileWriter(csvFile)) {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(new FileReader(jsonFile));
            Iterator<String> fieldNames = jsonNode.get(0).fieldNames();
            StringBuilder header = new StringBuilder();
            while (fieldNames.hasNext()) {
                header.append(fieldNames.next()).append(",");
            }
            writer.append(header.substring(0, header.length() - 1)).append("\n");
            for (JsonNode node : jsonNode) {
                StringBuilder row = new StringBuilder();
                for (String fieldName : node.fieldNames()) {
                    row.append(node.get(fieldName).asText()).append(",");
                }
                writer.append(row.substring(0, row.length() - 1)).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void csvToJson(String csvFile, String jsonFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile));
             FileWriter writer = new FileWriter(jsonFile)) {
            String line;
            String[] headers = br.readLine().split(",");
            StringBuilder jsonBuilder = new StringBuilder();
            jsonBuilder.append("[\n");
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                jsonBuilder.append("  {\n");
                for (int i = 0; i < headers.length; i++) {
                    jsonBuilder.append("    \"").append(headers[i]).append("\": \"").append(values[i]).append("\"");
                    if (i < headers.length - 1) jsonBuilder.append(",\n");
                }
                jsonBuilder.append("\n  },\n");
            }
            jsonBuilder.delete(jsonBuilder.length() - 2, jsonBuilder.length()).append("\n]");
            writer.write(jsonBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        jsonToCsv("students.json", "students.csv");
        csvToJson("students.csv", "students_output.json");
    }
}