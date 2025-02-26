import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class StudentJson {
    public static void main(String[] args) throws IOException {
        Student student = new Student("John Doe", 20, new String[]{"Math", "Science", "History"});
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("student.json"), student);
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