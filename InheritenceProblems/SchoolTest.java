public class SchoolTest {
    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        teacher.name = "Mr. Smith";
        teacher.age = 40;
        teacher.subject = "Mathematics";
        teacher.displayRole();

        Student student = new Student();
        student.name = "Alice";
        student.age = 16;
        student.grade = 10;
        student.displayRole();
    }
}
class Person {
    String name;
    int age;
}

class Teacher extends Person {
    String subject;

    void displayRole() {
        System.out.println("Role: Teacher, Subject: " + subject);
    }
}

class Student extends Person {
    int grade;

    void displayRole() {
        System.out.println("Role: Student, Grade: " + grade);
    }
}

class Staff extends Person {
    String position;

    void displayRole() {
        System.out.println("Role: Staff, Position: " + position);
    }
}



