import java.lang.reflect.Constructor;

class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class DynamicallObject {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Student.class;
        Constructor<?> constructor = clazz.getConstructor(String.class);
        Student student = (Student) constructor.newInstance("John Doe");
        System.out.println("Student Name: " + student.getName());
    }
}