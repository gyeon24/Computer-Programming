package lab03_handout;

import javax.swing.*;
import java.awt.*;

public class Mile2Killometer extends JFrame {
    public Mile2Killometer() {
        setLayout(new BorderLayout());
        JPanel p1, p2;
        JTextField inputTextField, outputTextField;
        JButton b1;
        setTitle("마일을 킬로미터로 변환");
        p1 = new JPanel();
        p1.setLayout(new FlowLayout());
		
		p1.add(new JLabel("거리(마일): "));
        inputTextField = new JTextField(10);
        p1.add(inputTextField);

        p1.add(new JLabel("거리(Km): "));
        outputTextField = new JTextField(10);
        p1.add(outputTextField);

		b1 = new JButton("변환");
        p2 = new JPanel();
        p2.add(b1);

        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.SOUTH);

        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Mile2Killometer f = new Mile2Killometer();
    }
}
