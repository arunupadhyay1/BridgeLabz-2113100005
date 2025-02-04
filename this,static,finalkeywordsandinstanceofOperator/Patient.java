class Patient {
    private static String hospitalName = "City Hospital";
    private static int totalPatients = 0;
    private final String patientID;
    private String name;
    private int age;
    private String ailment;
    public Patient(String name, int age, String ailment, String patientID) {
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        this.patientID = patientID;
        totalPatients++;
    }
    public static int getTotalPatients() {
        return totalPatients;
    }
    public void displayPatientDetails() {
        System.out.println("Patient ID: " + patientID);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Ailment: " + ailment);
        System.out.println("Hospital Name: " + hospitalName);
    }
    public static void main(String[] args) {
        Patient patient1 = new Patient("Alice Smith", 30, "Flu", "P001");
        Patient patient2 = new Patient("Bob Johnson", 45, "Cold", "P002");
		Patient patient3 = new Patient("Jack tyson", 23, "Fever", "P003");
        if (patient1 instanceof Patient) {
            patient1.displayPatientDetails();
        }        
        if (patient2 instanceof Patient) {
            patient2.displayPatientDetails();
        }
		if (patient3 instanceof Patient) {
            patient3.displayPatientDetails();
        }
        System.out.println("\nTotal Patients Admitted: " + Patient.getTotalPatients());
    }
}

