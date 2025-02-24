import java.lang.reflect.Field;

public class JSONRepresent {
    public static String toJson(Object obj) throws Exception {
        StringBuilder json = new StringBuilder("{");
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            json.append("\"").append(field.getName()).append("\": \"").append(field.get(obj)).append("\", ");
        }
        json.setLength(json.length() - 2);
        json.append("}");
        return json.toString();
    }

    public static void main(String[] args) throws Exception {
        Person person = new Person();
        person.name = "John";
        person.age = 30;
        System.out.println(toJson(person));
    }
}

class Person {
    public String name;
    public int age;
}