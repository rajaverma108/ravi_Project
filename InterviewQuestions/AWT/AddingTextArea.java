package InterviewQuestions.AWT;

import java.awt.*;

public class AddingTextArea {
    private static void AddingTextArea() {
        Frame frame = new Frame();
        TextArea area = new TextArea("Welcome To Java");
        area.setBounds(10, 30, 400, 400);
        frame.add(area);
        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        AddingTextArea();
    }
}
