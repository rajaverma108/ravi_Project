package InterviewQuestions.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataBaseConnection {
    public static void main(String[] args) {
        try {
            //Step:1 load the driver class
            Class.forName("org.postgresql.Driver");
            //Step:2 create the connection object
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");
            //Step:3 create the statement object
            Statement statement = con.createStatement();
            //Step:4 execute query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM public.\"emp\"");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " "
                        + resultSet.getString(2) + " " + resultSet.getString(3)
                +" " + resultSet.getString(4)+" " + resultSet.getString(5));
                //Step:5  close the connection object
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
