import java.sql.Connection;
import java.sql.DriverManager;

public class testclass {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/databasedb";
        String user = "student1";
        String password = "pass";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connection successful!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}