public class StudentRecordManagement {
    public static void main(String[] args) {
        StudentLinkedList studentList = new StudentLinkedList();
        studentList.addAtEnd(1, "Alice", 20, "A");
        studentList.addAtEnd(2, "Bob", 21, "B");
        studentList.addAtBeginning(3, "Charlie", 19, "A+");
        studentList.addAtPosition(1, 4, "David", 22, "B+");
        System.out.println("All Student Records:");
        studentList.displayAll();
        Student foundStudent = studentList.searchByRollNumber(2);
        if (foundStudent != null) {
        System.out.println("Found Student: Roll Number: " + foundStudent.rollNumber + ", Name: " + foundStudent.name + ", Age: " + foundStudent.age + ", Grade: " + foundStudent.grade);
        } else {
            System.out.println("Student not found.");
        }
        studentList.updateGrade(2, "A-");
        System.out.println("\nAll Student Records after update:");
        studentList.displayAll();
        studentList.deleteByRollNumber(3);
        System.out.println("\nAll Student Records after deletion:");
        studentList.displayAll();
        studentList.deleteByRollNumber(5);
    }
}
class Student {
    int rollNumber;
    String name;
    int age;
    String grade;
    Student next;

    public Student(int rollNumber, String name, int age, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

class StudentLinkedList {
    private Student head;
// Add a new student record at the beginning
    public void addAtBeginning(int rollNumber, String name, int age, String grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        newStudent.next = head;
        head = newStudent;
    }
 // Add a new student record at the end
    public void addAtEnd(int rollNumber, String name, int age, String grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        if (head == null) {
            head = newStudent;
            return;
        }
        Student current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newStudent;
    }
// Add a new student record at a specific position
    public void addAtPosition(int position, int rollNumber, String name, int age, String grade) {
        if (position == 0) {
            addAtBeginning(rollNumber, name, age, grade);
            return;
        }
        Student newStudent = new Student(rollNumber, name, age, grade);
        Student current = head;
        for (int i = 0; i < position - 1 && current != null; i++) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Position out of bounds.");
            return;
        }
        newStudent.next = current.next;
        current.next = newStudent;
    }
// Delete a student record by Roll Number
    public void deleteByRollNumber(int rollNumber) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.rollNumber == rollNumber) {
            head = head.next;
            return;
        }
        Student current = head;
        while (current.next != null && current.next.rollNumber != rollNumber) {
            current = current.next;
        }
        if (current.next == null) {
            System.out.println("Student with Roll Number " + rollNumber + " not found.");
            return;
        }
        current.next = current.next.next;
    }
// Search for a student record by Roll Number
    public Student searchByRollNumber(int rollNumber) {
        Student current = head;
        while (current != null) {
            if (current.rollNumber == rollNumber) {
                return current;
            }
            current = current.next;
        }
        return null;
    }
// Display all student records
    public void displayAll() {
        Student current = head;
        if (current == null) {
            System.out.println("No student records found.");
            return;
        }
        while (current != null) {
            System.out.println("Roll Number: " + current.rollNumber + ", Name: " + current.name + ", Age: " + current.age + ", Grade: " + current.grade);
            current = current.next;
        }
    }
// Update a student's grade based on their Roll Number
    public void updateGrade(int rollNumber, String newGrade) {
        Student student = searchByRollNumber(rollNumber);
        if (student != null) {
            student.grade = newGrade;
            System.out.println("Grade updated for Roll Number " + rollNumber);
        } else {
            System.out.println("Student with Roll Number " + rollNumber + " not found.");
        }
    }
}

