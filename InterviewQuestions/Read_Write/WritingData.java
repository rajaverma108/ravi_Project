package InterviewQuestions.Read_Write;

import java.io.FileOutputStream;

public class WritingData {
    public static void main(String[] args) {
        try {
            FileOutputStream fileOutputStream =
                    new FileOutputStream("D:\\Git\\ravi_Project\\InterviewQuestions\\Read_Write\\note.txt");
            fileOutputStream.write(66);
            fileOutputStream.close();
            System.out.println("successful...");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
