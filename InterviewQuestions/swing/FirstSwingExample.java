package InterviewQuestions.swing;

import javax.swing.*;

public class FirstSwingExample {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();   //Creating instance of jFrame
        JButton button = new JButton("Click");  //Creating instance of JButton
        button.setBounds(130, 100, 100, 40);   //x-axis,y-axis ,width,height
        jFrame.add(button); //Adding button to jFrame
        jFrame.setSize(400, 500);    //400 width ,500 height
        jFrame.setLayout(null);     //using no layout manager
        jFrame.setVisible(true);       //making frame visible
    }
}
