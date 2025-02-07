public class VehicleManagementTest {
    public static void main(String[] args) {
        ElectricVehicle electricVehicle = new ElectricVehicle();
        electricVehicle.model = "Tesla Model S";
        electricVehicle.maxSpeed = 250;
        electricVehicle.charge();

        PetrolVehicle petrolVehicle = new PetrolVehicle();
        petrolVehicle.model = "Ford Mustang";
        petrolVehicle.maxSpeed = 200;
        petrolVehicle.refuel();
    }
}
class Vehicle {
    int maxSpeed;
    String model;
}

interface Refuelable {
    void refuel();
}

class ElectricVehicle extends Vehicle {
    void charge() {
        System.out.println("Charging electric vehicle");
    }
}

class PetrolVehicle extends Vehicle implements Refuelable {
    public void refuel() {
        System.out.println("Refueling petrol vehicle");
    }
}


