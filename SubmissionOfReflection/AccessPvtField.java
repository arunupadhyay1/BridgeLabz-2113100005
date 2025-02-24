import java.lang.reflect.Field;

class Person {
    private int age = 25;
}

public class AccessPvtField {
    public static void main(String[] args) throws Exception {
        Person person = new Person();
        Field field = Person.class.getDeclaredField("age");
        field.setAccessible(true);
        System.out.println("Original Age: " + field.get(person));
        field.set(person, 30);
        System.out.println("Updated Age: " + field.get(person));
    }
}