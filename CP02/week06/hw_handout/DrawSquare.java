package lab06_handout.hw_handout;

import java.awt.*;
import java.awt.event.*;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawSquare {

	public static void main(String[] args) {
		JFrame f = new JFrame("Draw Square");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//TODO: 사각형을 이동시킬 수 있는 패널을 생성하고, 프레임에 추가
		DrawSquarePanel movepanel = new DrawSquarePanel();
		f.add(movepanel);


		f.setSize(600, 200);
		f.setVisible(true);
	}
}

class DrawSquarePanel extends JPanel {
	private int squareX = 50;     //사각형의 초기 x 위치
	private int squareY = 50;     //사각형의 초기 y 위치
	private int squareW = 60;     //사각형의 가로 길이
	private int squareH = 60;     //사각형의 세로 길이

	public DrawSquarePanel() {
		setBorder(BorderFactory.createLineBorder(Color.black));

		// TODO: 익명클래스로 구현된 MouseListener를 패널에 등록,
		//  마우스 버튼을 누르면 이벤트가 발생한 위치를 moveSquare로 전달
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				moveSquare(x,y);
			}
	    });

		// TODO: 익명클래스로 구현된 MouseMotionListener를 패널에 등록
	    //  마우스로 드래그하면 이벤트가 발생한 위치를 moveSquare로 전달
		addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				moveSquare(x,y);
			}
		});
	}

	private void moveSquare(int x, int y) {

		squareX = x;
		squareY = y;

		 //TODO: 새로운 위치에 사각형을 표현한 패널을 다시 그리기
		repaint();

	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		// TODO: Graphics 객체를 사용해 (10, 20) 위치에
		//  "화면의 특정 위치를 클릭하면 그 위치로 사각형이 옮겨집니다!"
		//  라는 문자열 표현
		g.drawString("화면의 특정 위치를 클릭하면 그 위치로 사각형이 옮겨집니다!", 10,20);

		// TODO: Graphics 객체를 사용해 (10, 40) 위치에
		//  "마우스를 드래그하여 사각형을 원하는 위치로 옮길 수도 있습니다!" 라는 문자열 표현
		g.drawString("마우스를 드래그하여 사각형을 원하는 위치로 옮길 수도 있습니다!", 10,40);


		g.setColor(Color.RED);
		
		//TODO: squareX, squareY, squareW, squareH를
		// 사용해 빨강으로 채워진 사각형 그리기
		g.fillRect(squareX,squareY,squareW,squareH);


		g.setColor(Color.BLACK);
		//TODO: squareX, squareY, squareW, squareH를 사용해 채워지지 않은 검은색 사각형 그리기
		g.drawRect(squareX,squareY,squareW,squareH);

	}
}