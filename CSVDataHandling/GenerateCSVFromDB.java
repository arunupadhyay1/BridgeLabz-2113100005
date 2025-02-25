import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class GenerateCSVFromDB {
    public static void main(String[] args) {
        String csvFile = "employees_report.csv";
        String jdbcUrl = "jdbc:mysql://localhost:3306/your_database";
        String username = "your_username";
        String password = "your_password";

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             Statement stmt = conn.createStatement();
             FileWriter writer = new FileWriter(csvFile)) {
            writer.append("Employee ID,Name,Department,Salary\n");
            ResultSet rs = stmt.executeQuery("SELECT id, name, department, salary FROM employees");
            while (rs.next()) {
                writer.append(rs.getString(1) + "," + rs.getString(2) + "," + rs.getString(3) + "," + rs.getDouble(4) + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}