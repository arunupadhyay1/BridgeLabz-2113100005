public class Vehicle{
    private static double registrationFee = 1000.0;
    private final String registrationNumber;
    private String ownerName;
    private String vehicleType;
    public Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }
    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }
    public void displayRegistrationDetails() {
		if (this instanceof Vehicle){
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Number: " + registrationNumber);
        System.out.println("Registration Fee: $" + registrationFee);
    }}
    public static double getRegistrationFee() {
        return registrationFee;
    }
    public static void main(String[] args) {
        Vehicle vehicle1 = new Vehicle("John Doe", "Car", "ABC123");
        if (vehicle1 instanceof Vehicle) {
            vehicle1.displayRegistrationDetails();
        }
        Vehicle.updateRegistrationFee(1050.0);
        System.out.println("\nAfter updating registration fee:");
        if (vehicle1 instanceof Vehicle) {
            vehicle1.displayRegistrationDetails();
        }
    }
}