public class VehicleTest {
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[3];

        Car car = new Car();
        car.maxSpeed = 200;
        car.fuelType = "Petrol";
        car.seatCapacity = 5;
        vehicles[0] = car;

        Truck truck = new Truck();
        truck.maxSpeed = 120;
        truck.fuelType = "Diesel";
        truck.loadCapacity = 10000;
        vehicles[1] = truck;

        Motorcycle motorcycle = new Motorcycle();
        motorcycle.maxSpeed = 180;
        motorcycle.fuelType = "Petrol";
        motorcycle.hasSidecar = false;
        vehicles[2] = motorcycle;

        for (Vehicle vehicle : vehicles) {
            vehicle.displayInfo();
        }
    }
}
class Vehicle {
    int maxSpeed;
    String fuelType;

    void displayInfo() {
        System.out.println("Max Speed: " + maxSpeed + ", Fuel Type: " + fuelType);
    }
}

class Car extends Vehicle {
    int seatCapacity;

    void displayInfo() {
        super.displayInfo();
        System.out.println("Seat Capacity: " + seatCapacity);
    }
}

class Truck extends Vehicle {
    int loadCapacity;

    void displayInfo() {
        super.displayInfo();
        System.out.println("Load Capacity: " + loadCapacity);
    }
}

class Motorcycle extends Vehicle {
    boolean hasSidecar;

    void displayInfo() {
        super.displayInfo();
        System.out.println("Has Sidecar: " + hasSidecar);
    }
}


