import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class MergeJson {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode json1 = objectMapper.readTree(new File("json1.json"));
        JsonNode json2 = objectMapper.readTree(new File("json2.json"));
        JsonNode merged = objectMapper.createObjectNode().setAll((ObjectNode) json1).setAll((ObjectNode) json2);
        objectMapper.writeValue(new File("merged.json"), merged);
    }
}