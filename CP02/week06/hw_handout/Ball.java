package lab06_handout.hw_handout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

class Ball {
	int x, y, xInc, yInc, diameter;
	final Random r = new Random();
	Color color;

	public Ball(int d) { 
		this.diameter = d;

		x = (int) (Math.random() * (BouncingBalls.WIDTH - d) + 3);     //Ball의 초기 x 위치
		y = (int) (Math.random() * (BouncingBalls.HEIGHT - d) + 3);     //Ball의 초기 y 위치
		xInc = (int) (Math.random() * 5 + 1);     //Ball의 x 위치 증감치
		yInc = (int) (Math.random() * 5 + 1);     //Ball의 y 위치 증감치

		//TODO: Ball의 색 지정 - Random 객체를 사용해 발생한 0~255 범위의 정수로 RGB 값 설정한 Color 객체 생성
		color = new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
	}

	public void paint(Graphics g) {
		if (x < 0 || x > (BouncingBalls.WIDTH - diameter))
			xInc = -xInc;
		if (y < 0 || y > (BouncingBalls.HEIGHT - diameter))
			yInc = -yInc;

		 //TODO: Ball의 x 위치 증감 시키기
		x += xInc;

		 //TODO: Ball의 y 위치 증감 시키기
		y += yInc;

		g.setColor(color);

		//TODO: 지름(diameter) 크기의 Ball을 (x, y) 위치에 그리기
		g. fillOval(x,y,diameter,diameter);

	}
}

public class BouncingBalls extends JFrame implements ActionListener {
	static final int WIDTH = 600;
	static final int HEIGHT = 200;
	private static final int PERIOD = 10;

	class BouncingBallPanel extends JPanel {
		public Ball basket[] = new Ball[10]; 

		public BouncingBallPanel() {
			for (int i = 0; i < 10; i++)
				basket[i] = new Ball((int) (30 + 30 * Math.random()));   // 30~60 사이의 랜덤한 정수를 지름으로 하는 Ball을 10개 만들어 배열에 저장
		}

		public void paintComponent(Graphics g) {   //TODO: 패널에 Ball 10개를 새로 그리기
			super.paintComponent(g);
			for (Ball b : basket) {
				b.paint(g);
			}
		}
	}

	public BouncingBalls() {
		
		 //TODO: Ball들을 그릴 수 있는 Panel 생성
		JPanel panel = new BouncingBallPanel();
		panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		add(panel);
		pack();	
						
		setTitle("Bouncing Balls");
		Timer timer = new Timer(PERIOD, this);   //Timer 객체에 의해 10millisecond 마다 등록된 ActionListener 처리
		timer.start();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		 // TODO: 이벤트 발생 시 다시 그리기

	}

	public static void main(String[] args) {
		new BouncingBalls();
	}
}