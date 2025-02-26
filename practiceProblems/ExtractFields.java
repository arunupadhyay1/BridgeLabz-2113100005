import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ExtractFields {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(new File("data.json"));
        String name = jsonNode.get("name").asText();
        String email = jsonNode.get("email").asText();
        System.out.println("Name: " + name + ", Email: " + email);
    }
}
