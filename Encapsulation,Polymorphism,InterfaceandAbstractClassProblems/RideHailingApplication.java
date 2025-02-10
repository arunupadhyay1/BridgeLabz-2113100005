public class RideHailingApplication {
    public static void main(String[] args) {
        Vehicle car = new Car("CAR123", "Alice", 10);
        Vehicle bike = new Bike("BIKE123", "Bob", 5);

        // Cast to GPS to call updateLocation
        ((GPS) car).updateLocation("Downtown");
        ((GPS) bike).updateLocation("Uptown");

        System.out.println(car.getVehicleDetails());
        System.out.println("Current Location: " + ((GPS) car).getCurrentLocation());
        System.out.println("Fare for 10 km: " + car.calculateFare(10));

        System.out.println(bike.getVehicleDetails());
        System.out.println("Current Location: " + ((GPS) bike).getCurrentLocation());
        System.out.println("Fare for 10 km: " + bike.calculateFare(10));
    }
}
interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

// Abstract Class
abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    // Protected getter for ratePerKm
    protected double getRatePerKm() {
        return ratePerKm;
    }

    public abstract double calculateFare(double distance);

    public String getVehicleDetails() {
        return "Vehicle ID: " + vehicleId + ", Driver Name: " + driverName + ", Rate per Km: " + ratePerKm;
    }
}

// Subclass for Car
class Car extends Vehicle implements GPS {
    private String currentLocation;

    public Car(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = "Unknown"; // Default location
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm(); // Use the protected getter
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }
}

// Subclass for Bike
class Bike extends Vehicle implements GPS {
    private String currentLocation;

    public Bike(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = "Unknown"; // Default location
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm(); // Use the protected getter
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }
}

