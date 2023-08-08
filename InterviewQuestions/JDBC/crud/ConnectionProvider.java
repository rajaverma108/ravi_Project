package InterviewQuestions.JDBC.crud;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
    static Connection con;

    public static Connection createConnection() {
        try {
            //load the driver
            Class.forName("org.postgresql.Driver");
            //create connection
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/student", "postgres", "root");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;

    }
}
