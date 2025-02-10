public class VehicleRentalSystem {
    public static void main(String[] args) {
        Vehicle vehicle1 = new Car("CAR123", 200);
        Vehicle vehicle2 = new Bike("BIKE123", 100);

        System.out.println(vehicle1.getVehicleDetails());
        System.out.println("Rental Cost for 5 days: " + vehicle1.calculateRentalCost(5));
        System.out.println(((Insurable) vehicle1).getInsuranceDetails());

        System.out.println(vehicle2.getVehicleDetails());
        System.out.println("Rental Cost for 3 days: " + vehicle2.calculateRentalCost(3));
        System.out.println(((Insurable) vehicle2).getInsuranceDetails());
    }
}

interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

// Abstract Class
abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    protected double getRentalRate() { // Protected getter for rentalRate
        return rentalRate;
    }

    public abstract double calculateRentalCost(int days);

    public String getVehicleDetails() {
        return "Vehicle Number: " + vehicleNumber + ", Type: " + type + ", Rental Rate: " + rentalRate;
    }
}

// Subclass for Car
class Car extends Vehicle implements Insurable {
    public Car(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Car", rentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return days * getRentalRate(); // Use the protected getter
    }

    @Override
    public double calculateInsurance() {
        return 100; // Fixed insurance cost
    }

    public String getInsuranceDetails() {
        return "Insurance Cost: " + calculateInsurance();
    }
}

// Subclass for Bike
class Bike extends Vehicle implements Insurable {
    public Bike(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Bike", rentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return days * getRentalRate(); // Use the protected getter
    }

    @Override
    public double calculateInsurance() {
        return 50; // Fixed insurance cost
    }

    public String getInsuranceDetails() {
        return "Insurance Cost: " + calculateInsurance();
    }
}
