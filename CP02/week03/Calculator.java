package lab03_handout;

import javax.swing.*;
import java.awt.*;

public class Calculator extends JFrame {

    private JPanel p1, p2, p3;
    private JTextField outputField;
    private JButton[] buttons;
    private String[] labels = {
            "7", "8", "9", "/", "4", "5", "6", "*",
            "1", "2", "3", "-", "0", "back", "=", "+"
    };

    public Calculator() {

        p1 = new JPanel(new BorderLayout());
        p1.setBorder(BorderFactory.createEmptyBorder(10,50,10,50));
        outputField = new JTextField(20);
        outputField.setEnabled(false);
        p1.add(outputField, BorderLayout.CENTER);
        add(p1, BorderLayout.NORTH);

        p2 = new JPanel(new GridLayout(0,4,5,5));
        JButton b1 = new JButton("C");
        p2.setBorder(BorderFactory.createEmptyBorder(5,10,0,10));
        p2.add(b1);
        add(p2, BorderLayout.CENTER);

        p3 = new JPanel();
		p3.setLayout(new GridLayout(4,4, 5, 5));
        buttons = new JButton[16];
        int index = 0;
        for (int rows = 0; rows < 4; rows++) {
            for (int cols = 0; cols < 4; cols++) {
                buttons[index] = new JButton(labels[index]);
                p3.add(buttons[index]);
                index++;
            }
        }
        p3.setBorder(BorderFactory.createEmptyBorder(10,10,5,10));
        add(p3, BorderLayout.SOUTH);



        setVisible(true);
        pack();
    }

    public static void main(String args[]) {
        Calculator s = new Calculator();
    }
}
