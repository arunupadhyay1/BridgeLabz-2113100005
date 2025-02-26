import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class FilterUsersOlderThan25 {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(new File("users.json"));
        for (JsonNode node : jsonNode) {
            if (node.get("age").asInt() > 25) {
                System.out.println(node);
            }
        }
    }
}