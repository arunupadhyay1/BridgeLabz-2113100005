import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class PrintJsonKeysValues {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(new File("data.json"));
        jsonNode.fields().forEachRemaining(entry -> {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        });
    }
}