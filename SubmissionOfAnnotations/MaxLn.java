import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface MaxLength {
    int value();
}

class User {
    @MaxLength(10)
    private String username;

    User(String username) {
        if (username.length() > 10) {
            throw new IllegalArgumentException("Username exceeds maximum length of " + 10);
        }
        this.username = username;
    }
}

public class MaxLn {
    public static void main(String[] args) {
        try {
            User user = new User("ThisUsernameIsTooLong");
            System.out.println("User  created successfully.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            User user = new User("ShortName");
            System.out.println("User  created successfully with username: " + user.username);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}