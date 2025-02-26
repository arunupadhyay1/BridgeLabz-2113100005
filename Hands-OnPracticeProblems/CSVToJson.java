import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class CsvToJson {
    public static void main(String[] args) throws IOException {
        CsvMapper csvMapper = new CsvMapper();
		CsvSchema schema = CsvSchema.emptySchema().withHeader();
        List<Object> data = csvMapper.readerFor(Object.class).with(schema).readValues(new File("data.csv")).readAll();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("data.json"), data);
    }
}