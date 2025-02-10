public class HospitalPatientManagement {
    public static void main(String[] args) {
        InPatient inPatient = new InPatient("IP001", "Alice", 30, 200, 5);
        inPatient.addRecord("Admitted for surgery.");
        inPatient.addRecord("Surgery successful.");

        System.out.println(inPatient.getPatientDetails());
        System.out.println("Total Bill: " + inPatient.calculateBill());
        System.out.println("Medical Records:\n" + inPatient.viewRecords());

        OutPatient outPatient = new OutPatient("OP001", "Bob", 25, 150);
        outPatient.addRecord("Consulted for fever.");

        System.out.println(outPatient.getPatientDetails());
        System.out.println("Total Bill: " + outPatient.calculateBill());
        System.out.println("Medical Records:\n" + outPatient.viewRecords());
    }
}
interface MedicalRecord {
    void addRecord(String record);
    String viewRecords();
}

// Abstract Class
abstract class Patient {
    private String patientId;
    private String name;
    private int age;

    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public abstract double calculateBill();

    public String getPatientDetails() {
        return "Patient ID: " + patientId + ", Name: " + name + ", Age: " + age;
    }
}

// Subclass for In-Patients
class InPatient extends Patient implements MedicalRecord {
    private double dailyRate;
    private int daysAdmitted;
    private StringBuilder records;

    public InPatient(String patientId, String name, int age, double dailyRate, int daysAdmitted) {
        super(patientId, name, age);
        this.dailyRate = dailyRate;
        this.daysAdmitted = daysAdmitted;
        this.records = new StringBuilder();
    }

    @Override
    public double calculateBill() {
        return dailyRate * daysAdmitted;
    }

    @Override
    public void addRecord(String record) {
        records.append(record).append("\n");
    }

    @Override
    public String viewRecords() {
        return records.toString();
    }
}

// Subclass for Out-Patients
class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private StringBuilder records;

    public OutPatient(String patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
        this.records = new StringBuilder();
    }

    @Override
    public double calculateBill() {
        return consultationFee; // Only consultation fee
    }

    @Override
    public void addRecord(String record) {
        records.append(record).append("\n");
    }

    @Override
    public String viewRecords() {
        return records.toString();
    }
}

