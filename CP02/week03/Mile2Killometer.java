package lab03_handout;

import javax.swing.*;
import java.awt.*;

public class Mile2Killometer extends JFrame {
    public Mile2Killometer() {
        setLayout(new BorderLayout());
        JPanel p1, p2, p3;
        JButton b1, b2;

        p1 = new JPanel();
        p1.setLayout(new FlowLayout());
		p1.add(new JLabel("회원 등록하기"));
        add(p1, BorderLayout.NORTH);

        p2 = new JPanel(new GridLayout(4,2,25,10));
		p2.add(new JLabel("이름"));
        p2.add(new JTextField(10));
        p2.add(new JLabel("패스워드"));
        p2.add(new JPasswordField(10));
        p2.add(new JLabel("이메일 주소"));
        p2.add(new JTextField(10));
        p2.add(new JLabel("전화번호"));
        p2.add(new JTextField(10));
        p2.setBorder(BorderFactory.createEmptyBorder(10,30,10,30));
        add(p2, BorderLayout.CENTER);

        b1 = new JButton("등록하기");
        b2 = new JButton("취소");
        p3 = new JPanel();
        p3.setLayout(new FlowLayout());
        p3.add(b1);
        p3.add(b2);
        add(p3, BorderLayout.SOUTH);

        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Mile2Killometer f = new Mile2Killometer();
    }
}
