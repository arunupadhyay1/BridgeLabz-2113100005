import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListToJsonArray {
    public static void main(String[] args) throws IOException {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Toyota", "Camry", 2020));
        cars.add(new Car("Honda", "Accord", 2019));
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("cars.json"), cars);
    }
}