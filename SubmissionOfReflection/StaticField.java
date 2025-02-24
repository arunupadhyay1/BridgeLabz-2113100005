import java.lang.reflect.Field;

class Configuration {
    private static String API_KEY = "12345";
}

public class StaticField {
    public static void main(String[] args) throws Exception {
        Field field = Configuration.class.getDeclaredField("API_KEY");
        field.setAccessible(true);
        System.out.println("Original API_KEY: " + field.get(null));
        field.set(null, "67890");
        System.out.println("Updated API_KEY: " + field.get(null));
    }
}