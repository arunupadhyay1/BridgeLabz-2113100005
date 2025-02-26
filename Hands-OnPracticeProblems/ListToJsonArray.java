import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListToJsonArray {
    public static void main(String[] args) throws IOException {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 22, new String[]{"Math", "Physics"}));
        students.add(new Student("Bob", 24, new String[]{"Chemistry", "Biology"}));
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("students.json"), students);
    }
}

class Student {
    private String name;
    private int age;
    private String[] subjects;

    public Student(String name, int age, String[] subjects) {
        this.name = name;
        this.age = age;
        this.subjects = subjects;
    }
}