package InterviewQuestions.swing;

import javax.swing.*;

public class AddingCheckboxExample {
    AddingCheckboxExample(){
        JFrame jFrame = new JFrame("CheckBox Example");
        JCheckBox checkBox = new JCheckBox("java");
        checkBox.setBounds(100,100,50,50);
        JCheckBox checkBox1 = new JCheckBox("Python");
        checkBox1.setBounds(100,150,50,50);
        jFrame.add(checkBox);
        jFrame.add(checkBox1);
        jFrame.setSize(400,400);
        jFrame.setLayout(null);
        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new AddingCheckboxExample();
    }
}
