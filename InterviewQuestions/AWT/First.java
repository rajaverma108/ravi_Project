package InterviewQuestions.AWT;

import java.awt.*;

public class First extends Frame {
    First() {
        Button button = new Button("Click Me");
        button.setBounds(30, 100, 80, 30);//Setting Button position
        add(button);//Adding Button into frame
        setSize(300, 300); //frame size 300W and 300H
        setLayout(null);    //no layout manager
        setVisible(true);   //now frame will be visible, by default not visible

    }

    public static void main(String[] args) {
        First first = new First();
    }
}
