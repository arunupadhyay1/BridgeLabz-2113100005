public class SmartHomeTest {
    public static void main(String[] args) {
        Thermostat thermostat = new Thermostat();
        thermostat.deviceId = "T123";
        thermostat.status = "Active";
        thermostat.temperatureSetting = 22;
        thermostat.displayStatus();
    }
}
class Device {
    String deviceId;
    String status;

    void displayStatus() {
        System.out.println("Device ID: " + deviceId + ", Status: " + status);
    }
}

class Thermostat extends Device {
    int temperatureSetting;

    void displayStatus() {
        super.displayStatus();
        System.out.println("Temperature Setting: " + temperatureSetting);
    }
}


