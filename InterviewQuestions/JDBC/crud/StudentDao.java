package InterviewQuestions.JDBC.crud;

import java.sql.*;

public class StudentDao {
    public static boolean insertStudentToDb(StudentModel studentModel) {
        boolean flag = false;
        try {
            //jdbc code
            Connection con = ConnectionProvider.createConnection();
            String qur = "INSERT INTO public.\"Students\"(sid, sname, sphone, scity)VALUES (?, ?, ?, ?)";
            //prepared Statement
            PreparedStatement preparedStatement = con.prepareStatement(qur);
            //set the values of parameter
            preparedStatement.setInt(1, studentModel.getStudentId());
            preparedStatement.setString(2, studentModel.getStudentName());
            preparedStatement.setLong(3, studentModel.getStudentPhone());
            preparedStatement.setString(4, studentModel.getStudentCity());

            //execute
            preparedStatement.executeUpdate();
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public static boolean delete(int id) {
        boolean flag = false;
        try {
            //jdbc code
            Connection con = ConnectionProvider.createConnection();
            String qur = "DELETE FROM public.\"Students\"WHERE sid=?;";
            //prepared Statement
            PreparedStatement preparedStatement = con.prepareStatement(qur);
            //set the values of parameter
            preparedStatement.setInt(1, id);
            //execute
            preparedStatement.executeUpdate();
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public static void showAllStudent() throws SQLException {
        Connection con = ConnectionProvider.createConnection();
        String qur = "SELECT * FROM public.\"Students\"";
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery(qur);

        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            long phone = resultSet.getLong(3);
            String city =resultSet.getString(4);
            System.out.println("Id :"+id);
            System.out.println("name :"+name);
            System.out.println("Phone number :"+phone);
            System.out.println("City :"+city);
            System.out.println("------------------------------------");
        }
    }
}
