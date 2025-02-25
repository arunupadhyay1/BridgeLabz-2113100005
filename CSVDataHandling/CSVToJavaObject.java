import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class CSVToJavaObject {
    public static void main(String[] args) {
        String csvFile = "students.csv";
        String line;
        List<Student> students = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                students.add(new Student(data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
class Student {
    String id;
    String name;
    int age;
    int marks;

    public Student(String id, String name, int age, int marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return String.format("ID: %s, Name: %s, Age: %d, Marks: %d", id, name, age, marks);
    }
}

