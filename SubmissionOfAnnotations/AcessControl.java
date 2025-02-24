import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface RoleAllowed {
    String value();
}

class UserService {
    @RoleAllowed("ADMIN")
    void adminTask() {
        System.out.println("Admin task executed.");
    }
}

public class AcessControl {
    public static void main(String[] args) {
        UserService userService = new UserService();
        String userRole = "USER"; // Simulating a non-admin user

        if (userRole.equals("ADMIN")) {
            userService.adminTask();
        } else {
            System.out.println("Access Denied!");
        }
    }
}