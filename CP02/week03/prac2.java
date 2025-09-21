package lab03_handout;

import javax.swing.*;
import java.awt.*;

public class Calculator extends JFrame {

    private JPanel panel;
    private JTextField outputField;
    private JButton[] buttons;
    private String[] labels = {
            "Backspace", "", "", "CE", "C", "7", "8", "9", "/", "sqrt", "4", "5", 
			"6", "x", "%", "1", "2", "3", "-", "1/x", "0", "+/-", ".", "+", "=",
    };

    public Calculator() {
        outputField = new JTextField(35);
        panel = new JPanel();
        outputField.setText("0.");
        outputField.setEnabled(false);

		panel.setLayout(new GridLayout(5,5));

        buttons = new JButton[25];
        int index = 0;
        for (int rows = 0; rows < 5; rows++) {
            for (int cols = 0; cols < 5; cols++) {
                buttons[index] = new JButton(labels[index]);

                // 4번째, 5번째 컬럼의 버튼 글자 색깔을 빨간색으로 설정
                if( cols >= 3 )
                    buttons[index].setForeground(Color.red);
                else
                    buttons[index].setForeground(Color.blue);

					// 여기에 나머지 컬럼의 버튼 글자 색깔을 파란색으로 설정하는 코드 추가

                buttons[index].setBackground(Color.yellow);
				// 여기에 버튼의 배경 색깔을 노란색으로 설정하는 코드 추가
                panel.add(buttons[index]);
                index++;
            }
        }
        add(outputField, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        setVisible(true);
        pack();
    }

    public static void main(String args[]) {
        Calculator s = new Calculator();
    }
}
