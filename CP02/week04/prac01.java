package practice.handout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Mile2Killometer extends JFrame {
    public Mile2Killometer() {
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

        p2 = new JPanel();
        b1 = new JButton("변환");
        p2.add(b1);

        add(p1, "North"); 
		add(p2, "South");
        pack();

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// “변환” 버튼(b1)을 클릭했을 때 이를 처리할 수 있는 이벤트 리스너인 
		// ActionListener 객체를 만들어 버튼 b1에 등록하는 코드 (무명 클래스 방식 사용)

		b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String answer = inputTextField.getText();
                double mile = Double.parseDouble(answer);
                double kilo = mile*1.609;

                outputTextField.setText(String.format("%.3f", kilo));
                
				// 1) 여기에 입력 텍스트필드에서 마일 단위의 거리값을 받아와서 킬로미터 단위로 변환하는 코드를 작성한다.
				//   (1마일 = 1.609Km)
				//    이 때, 입력 테스트필드에서 얻어온 값은 문자열이므로 실수값으로 변환해서 killo 변수에 넣어야 한다.
				// 2) 출력 텍스트필드에 변환된 킬로미터 값을 소수점 이하 3자리까지 출력한다.
            }
        });
    }
    public static void main(String[] args) {
        Mile2Killometer f = new Mile2Killometer();
    }
}


