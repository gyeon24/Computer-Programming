package lab06_handout.handout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class TrafficLightPanel extends JPanel implements ActionListener {
	private int light_number = 0;
	public TrafficLightPanel() {
		setLayout(new BorderLayout());
		JButton b = new JButton("신호 변경");
		b.addActionListener(this);
		add(b, BorderLayout.SOUTH);
		// "신호 변경" 버튼을 패널 아래 쪽에 추가한다.
	}
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.drawOval(100, 10, 100, 100);
		g.drawOval(200,10,100,100);
		g.drawOval(300,10,100,100);
		// 여기에 나머지 불이 꺼진 신호등을 그리는 코드를 추가한다.
		if (light_number == 0) {
			g.setColor(Color.RED);
			g.fillOval(100, 10, 100, 100);
		}
		else if (light_number == 1) {
			g.setColor(Color.GREEN);
			g.fillOval(200,10,100,100);
		}
		else{
			g.setColor(Color.YELLOW);
			g.fillOval(300,10,100,100);
		}
	}
	public void actionPerformed(ActionEvent e) {
		light_number = (light_number + 1)%3;
		repaint();
		// 여기에 다음 신호등을 표시하는 코드를 추가한다.
		// 예를 들어, 현재 신호등이 빨간색이면 녹색 신호등을, 노란색이면 빨간색 신호등을 표시한다.
		// 힌트: light_number의 값을 적절히 변경한 후 repaint() 메소드를 호출한다.
	}
}
public class TrafficLight extends JFrame {
	public TrafficLight() {
		setTitle("Traffic Light");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new TrafficLightPanel());
		setSize(600, 200);
		setVisible(true);
	}
	public static void main(String[] arg) {	new TrafficLight(); }	
}

