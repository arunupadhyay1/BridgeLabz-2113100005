
public class EmployeeTest {
    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.name = "Alice";
        manager.id = 1;
        manager.salary = 80000;
        manager.teamSize = 5;
        manager.displayDetails();

        Developer developer = new Developer();
        developer.name = "Bob";
        developer.id = 2;
        developer.salary = 60000;
        developer.programmingLanguage = "Java";
        developer.displayDetails();

        Intern intern = new Intern();
        intern.name = "Charlie";
        intern.id = 3;
        intern.salary = 30000;
        intern.school = "XYZ University";
        intern.displayDetails();
    }
}
class Employee {
    String name;
    int id;
    double salary;

    void displayDetails() {
        System.out.println("Name: " + name + ", ID: " + id + ", Salary: " + salary);
    }
}

class Manager extends Employee {
    int teamSize;

    void displayDetails() {
        super.displayDetails();
        System.out.println("Team Size: " + teamSize);
    }
}

class Developer extends Employee {
    String programmingLanguage;

    void displayDetails() {
        super.displayDetails();
        System.out.println("Programming Language: " + programmingLanguage);
    }
}

class Intern extends Employee {
    String school;

    void displayDetails() {
        super.displayDetails();
        System.out.println("School: " + school);
    }
}

