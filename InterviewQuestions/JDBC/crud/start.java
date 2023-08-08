package InterviewQuestions.JDBC.crud;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class start {
    public static void main(String[] args) throws IOException, SQLException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("press 1 to Add Student");
            System.out.println("press 2 to delete Student");
            System.out.println("press 3 to display Student");
            System.out.println("press 4 to exit Student");
            int choice = Integer.parseInt(reader.readLine());
            int id = 0;
            switch (choice) {

                case 1:
                    //add student
                    System.out.println("Enter Student id");
                    id = Integer.parseInt(reader.readLine());
                    System.out.println("Enter Student Name");
                    String name = reader.readLine();
                    System.out.println("Enter Student Phone");
                    Long phone = Long.valueOf(reader.readLine());
                    System.out.println("Enter Student city");
                    String city = reader.readLine();

                    StudentModel studentManagementApp = new StudentModel(id, name, phone, city);
                    boolean ans = StudentDao.insertStudentToDb(studentManagementApp);
                    if (ans)
                        System.out.println("Student added successfully...");
                    else
                        System.out.println("Something went wrong try again..");
                    break;
                case 2:
                    //delete student
                    System.out.println("Enter Student id to delete");
                    id = Integer.parseInt(reader.readLine());
                    StudentDao.delete(id);
                    break;
                case 3:
                    //display student
                    System.out.println("Show All Students");
                    StudentDao.showAllStudent();
                    break;
                case 4:
                    //exit
                    System.out.println("thank you");
                    break;
            }
            break;
        }

    }
}
