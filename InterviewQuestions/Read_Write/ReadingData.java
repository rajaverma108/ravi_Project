package InterviewQuestions.Read_Write;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReadingData {
    public static void main(String[] args) throws IOException {
        try {
            FileInputStream fileInputStream =
                    new FileInputStream("D:\\Git\\ravi_Project\\InterviewQuestions\\Read_Write\\note.txt");
            int i = fileInputStream.read();
            System.out.println( (char) i);
            fileInputStream.close();
            System.out.println("successful...");
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
