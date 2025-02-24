import java.lang.reflect.Field;
import java.util.Map;

public class ObjectMapper {
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) throws Exception {
        T instance = clazz.getDeclaredConstructor().newInstance();
        for (Map.Entry<String, Object> entry : properties.entrySet()) {
            Field field = clazz.getDeclaredField(entry.getKey());
            field.setAccessible(true);
            field.set(instance, entry.getValue());
        }
        return instance;
    }

    public static void main(String[] args) throws Exception {
        Map<String, Object> properties = Map.of("name", "John", "age", 30);
        Person person = toObject(Person.class, properties);
        System.out.println("Person Name: " + person.name + ", Age: " + person.age);
    }
}

class Person {
    public String name;
    public int age;
}