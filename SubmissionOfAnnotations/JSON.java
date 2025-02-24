import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@interface JsonField {
    String name();
}

class User {
    @JsonField(name = "user_name")
    private String username;

    User(String username) {
        this.username = username;
    }

    String toJson() {
        StringBuilder json = new StringBuilder("{");
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(JsonField.class)) {
                JsonField jsonField = field.getAnnotation(JsonField.class);
                field.setAccessible(true);
                try {
                    json.append("\"").append(jsonField.name()).append("\": \"").append(field.get(this)).append("\", ");
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        json.setLength(json.length() - 2); // Remove last comma and space
        json.append("}");
        return json.toString();
    }
}

public class JSON {
    public static void main(String[] args) {
        User user = new User("JohnDoe");
        System.out.println(user.toJson());
    }
}