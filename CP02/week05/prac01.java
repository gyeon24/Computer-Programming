package lab05_handout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class PizzaOrder extends JFrame implements ActionListener {
	private int order_price;
	private JButton order_button, cancel_button;
	private JPanel welcome_panel, type_panel, topping_panel, size_panel, down_panel;
	private JTextField price_text;
	public PizzaOrder() {
		setSize(500, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("피자 주문");
		welcome_panel = new WelcomePanel();
		type_panel = new TypePanel();
		topping_panel= new ToppingPanel();
		size_panel = new SizePanel();
		down_panel = new JPanel(); //DownPanel 없음.
		order_button = new JButton("주문"); // '주문' 버튼 생성
		order_button.addActionListener(this); // 이벤트 처리 등록
		cancel_button = new JButton("취소");
		cancel_button.addActionListener(this);
		// '취소' 버튼 생성 및 이벤트 처리 등록
		price_text = new JTextField(); // '가격' 텍스트 필드 생성
		price_text.setEditable(false); // 수정이 불가하도록 설정
		price_text.setColumns(6); // 길이 6칸
		down_panel.add(order_button);
		down_panel.add(cancel_button);
		down_panel.add(price_text);
		// down_panel 패널에 order, cancel 버튼 및 price 텍스트 필드 추가
		setLayout(new BorderLayout()); // 프레임의 배치 관리자 설정
		add(welcome_panel, BorderLayout.NORTH); // welcome_panel은 북쪽
		add(down_panel, BorderLayout.SOUTH);
		add(size_panel, BorderLayout.EAST);
		add(type_panel, BorderLayout.WEST);
		add(topping_panel, BorderLayout.CENTER);
		// down_panel은 남쪽, size_panel은 동쪽에 추가
		// type_panel은 서쪽, topping_panel은 중앙에 추가
		setVisible(true); // 프레임 화면 표시
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == order_button) { // '주문' 버튼 클릭시
		  	order_price = 20000;
			this.price_text.setText("" + order_price);// 텍스트 필드에 가격 출력
		}
		if (e.getSource() == cancel_button) { // '취소' 버튼 클릭시
			order_price = 0;
			this.price_text.setText("" + order_price);
		}
	}

	class WelcomePanel extends JPanel {
		private JLabel message; // 메세지 라벨 참조 변수

		public WelcomePanel() { // 생성자
			message = new JLabel("자바 피자에 오신 것을 환영합니다"); // 레이블 생성
			add(message); // 라벨 생성 후 패널 객체에 추가
		}
	}

	class TypePanel extends JPanel {
		private JRadioButton combo, potato, bulgogi;
		private ButtonGroup bg; // 버튼 그룹 정의
		public TypePanel() { // 생성자
			setLayout(new GridLayout(3,1));
			combo = new JRadioButton("콤보", true);
			potato = new JRadioButton("포테이토", true);
            bulgogi = new JRadioButton("불고기", true);
			bg = new ButtonGroup(); // 버튼 그룹 생성
			bg.add(combo);
			bg.add(potato);
            bg.add(bulgogi);
			setBorder(BorderFactory.createTitledBorder("종류")); // 버튼 그룹 정리
			add(combo); // 타입 패널에 라디오 버튼 추가
			add(potato);
            add(bulgogi);
		}
	}

	class ToppingPanel extends JPanel {
		private JCheckBox pepper, cheese, peperoni, bacon;
		public ToppingPanel() { // 생성자
			setLayout(new GridLayout(4,1));
			pepper = new JCheckBox("피망");
            cheese = new JCheckBox("치즈");
            peperoni = new JCheckBox("페페로니");
            bacon = new JCheckBox("베이컨");
            setBorder(BorderFactory.createTitledBorder("추가토핑"));
			add(pepper);
			add(cheese);
			add(peperoni);
			add(bacon);
		}
	}

	class SizePanel extends JPanel {
		private JRadioButton small, medium, large;
		private ButtonGroup bg;
		public SizePanel() { // 생성자
			setLayout(new GridLayout(3,1));
			small = new JRadioButton("Small");
			medium = new JRadioButton("Medium");
			large = new JRadioButton("Large");
			bg = new ButtonGroup();
			bg.add(small);
			bg.add(medium);
			bg.add(large);// 버튼 그룹화
			setBorder(BorderFactory.createTitledBorder("크기"));
			// 크기 패널에 버튼 추가
			add(small);
			add(medium);
			add(large);
		}
	}

    public static void main(String[] args) {
        new PizzaOrder();
    }
}





