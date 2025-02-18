public class ResumeScreening {
    public static void main(String[] args) {
        Resume<SoftwareEngineer> resume = new Resume<>(new SoftwareEngineer());
        resume.processResume();
    }
}
abstract class JobRole {
    String title;
    public JobRole(String title) {
        this.title = title;
    }
}

class SoftwareEngineer extends JobRole {
    public SoftwareEngineer() {
        super("Software Engineer");
    }
}

class DataScientist extends JobRole {
    public DataScientist() {
        super("Data Scientist");
    }
}

class ProductManager extends JobRole {
    public ProductManager() {
        super("Product Manager");
    }
}

class Resume<T extends JobRole> {
    private T jobRole;

    public Resume(T jobRole) {
        this.jobRole = jobRole;
    }

    public T getJobRole() {
        return jobRole;
    }

    public void processResume() {
        System.out.println("Processing resume for: " + jobRole.title);
    }
}

