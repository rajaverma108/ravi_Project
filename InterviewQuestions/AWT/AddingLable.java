package InterviewQuestions.AWT;

import java.awt.*;

public class AddingLable {
    public static void main(String[] args) {
        Frame frame= new Frame("Lable Example");
        Label L1,L2;
        L1=new Label("First Lable ");
        L1.setBounds(50,100,100,30);
        L2= new Label("Second Lable");
        L2.setBounds(50,150,100,30);
        frame.add(L1);
        frame.add(L2);
        frame.setSize(400,400);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
