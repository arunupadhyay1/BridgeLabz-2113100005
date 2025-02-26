import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;

public class ValidateJson {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(new File("data.json"));
        if (jsonNode.has("name") && jsonNode.has("email")) {
            System.out.println("Valid JSON structure");
        } else {
            System.out.println("Invalid JSON structure");
        }
    }
}