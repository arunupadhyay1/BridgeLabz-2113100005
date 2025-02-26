import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GenerateJsonReport {
    public static void main(String[] args) throws Exception {
        List<User> users = fetchUsersFromDatabase();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("report.json"), users);
    }

    private static List<User> fetchUsersFromDatabase() throws Exception {
        List<User> users = new ArrayList<>();
        String url = "jdbc:mysql://localhost:3306/your_database";
        String user = "your_username";
        String password = "your_password";
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT name, email, age FROM users");
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            int age = resultSet.getInt("age");
            users.add(new User(name, email, age));
        }
        resultSet.close();
        statement.close();
        connection.close();
        return users;
    }
}

class User {
    private String name;
    private String email;
    private int age;

    public User(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }
}