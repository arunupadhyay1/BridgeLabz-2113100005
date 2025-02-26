import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class CarJson {
    public static void main(String[] args) throws IOException {
        Car car = new Car("Toyota", "Camry", 2020);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("car.json"), car);
    }
}

class Car {
    private String make;
    private String model;
    private int year;

    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }
}