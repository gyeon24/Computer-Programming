package lab05_handout;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;

class SizePrice {
	String size;
	int price;

	public SizePrice(String s, int p) {
		size=s;
		price=p;
	}
}

public class PizzaOrder extends JFrame implements ActionListener {
    private int totalPrice, basePrice, toppingPrice;
    private JButton orderButton, cancelButton;
    private JPanel welcomePanel, typePanel, toppingPanel, sizePanel, downPanel;
    private JTextField priceText;
    
    private String[] types;
    private String[] toppings; 
    private SizePrice[] sizePrice;
    
    public PizzaOrder(String[] types, String[] toppings, SizePrice[] sizePrice) {

        setSize(500, 200);       
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
        setTitle("피자 주문");  
        
        this.types = types;
        this.toppings = toppings;
        this.sizePrice = sizePrice;
                
        welcomePanel = new WelcomePanel();
        typePanel = new TypePanel();
        toppingPanel = new ToppingPanel();
        sizePanel = new SizePanel();
        downPanel = new JPanel();
        // TODO: '주문' 버튼 생성 및 이벤트 처리 등록
        orderButton = new JButton("주문");
        orderButton.addActionListener(this);

 
        
        // TODO: '취소' 버튼 생성 및 이벤트 처리 등록
        cancelButton = new JButton("취소");
        cancelButton.addActionListener(this);

 
        
        priceText = new JTextField();          //'가격' 텍스트 필드 생성
        priceText.setEditable(false);          //가격 텍스트 필드에서 가격 수정이 불가하도록 설정
        priceText.setColumns(6);             //길이 6칸
        
        downPanel.add(orderButton);          //'주문' 버튼 추가
        downPanel.add(cancelButton);          //'취소' 버튼 추가
        downPanel.add(priceText);            //'가격' 텍스트 필드 추가

        add(welcomePanel, BorderLayout.NORTH);    //welcome 패널 북쪽
        add(downPanel, BorderLayout.SOUTH);       //버튼 패널 남쪽
        add(sizePanel, BorderLayout.EAST);        //사이즈 패널 동쪽
        add(typePanel, BorderLayout.WEST);        //타입 패널 서쪽
        add(toppingPanel, BorderLayout.CENTER);   //토핑 패널 중앙
        
        setVisible(true); 
    }

    public void actionPerformed(ActionEvent e) {
        // TODO: totalPrice 계산       
        if (e.getSource() == cancelButton) {
            totalPrice = 0;
        }
        else {
            totalPrice = toppingPrice + basePrice;
        }
        
        priceText.setText(totalPrice+"원");
    }

    class WelcomePanel extends JPanel {
        private JLabel message;      // 메세지 라벨 참조 변수
        
        public WelcomePanel() { 
            message = new JLabel("자바 피자에 오신 것을 환영합니다.");
            add(message);           // 라벨 생성 후 객체에 추가
        }
    }

    class TypePanel extends JPanel {
        private JRadioButton[] buttons;        
        private ButtonGroup bg = new ButtonGroup();     
      
        public TypePanel() {  
            setLayout(new GridLayout(0, 1));
            setBorder(BorderFactory.createTitledBorder("종류"));
            buttons = new JRadioButton[types.length];

            // TODO: 피자 종류 라디오버튼 생성 후 그룹에 추가, 타입 패널에 라디오 버튼 추가
            for (int i=0; i<types.length; i++) {
                buttons[i] = new JRadioButton(types[i]);
                bg.add(buttons[i]);
                add(buttons[i]);
            }
        }
    }

    class ToppingPanel extends JPanel implements ItemListener {
        private JCheckBox[] buttons;
                
        public ToppingPanel() {  
            setLayout(new GridLayout(0, 1));
            
            buttons = new JCheckBox[toppings.length];
            // TODO: 체크박스 생성 후 이벤트 처리기 등록, 토핑 패널에 체크박스 추가
            for (int i = 0; i < toppings.length; i++) {
                buttons[i] =new JCheckBox(toppings[i]);
                buttons[i].addItemListener(this);
                add(buttons[i]);
            }

            setBorder(BorderFactory.createTitledBorder("추가토핑"));
        }
        
        public void itemStateChanged(ItemEvent e) {
            // TODO: 선택된 토핑에 따른 toppingPrice 계산
            if (e.getStateChange() == ItemEvent.SELECTED){
                for(int i=0;i<4;i++){
                    if(e.getSource() == buttons[i]) toppingPrice += 1000;
                }
            }
            else {
                for(int i=0;i<4;i++){
                    if(e.getSource() == buttons[i]) toppingPrice -= 1000;
                }
            }
                

        }
    }

    class SizePanel extends JPanel implements ActionListener{
        private JRadioButton[] buttons;
        private ButtonGroup bg = new ButtonGroup();

        public SizePanel() { 
            setLayout(new GridLayout(0, 1));
            buttons = new JRadioButton[sizePrice.length];

            // TODO: 피자 크기에 해당하는 라디오버튼 생성, 이벤트 처리기 등록, 버튼 그룹에 추가,  SizePanel에 추가
            for (int i = 0; i < sizePrice.length; i++) {
                buttons[i] = new JRadioButton(sizePrice[i].size);
                buttons[i].addActionListener(this);
                bg.add(buttons[i]);
                add(buttons[i]);
            }

            setBorder(BorderFactory.createTitledBorder("크기")); // 버튼 그룹 정리
        }

        public void actionPerformed(ActionEvent e) {
        	//TODO: 피자 크기에 따른 가격을 base_price에 할당
            for (int i = 0; i < sizePrice.length; i++){
                if (e.getSource() == buttons[i]) {
                    basePrice = sizePrice[i].price;
                      break;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        String[] types = {"콤보", "포테이토", "불고기"};
        String[] toppings = { "피망", "치즈", "페퍼로니", "베이컨"};
        SizePrice[] sizePrice = {new SizePrice("Small", 10000), new SizePrice("Medium", 15000), new SizePrice("Large", 20000)};        
            
        new PizzaOrder(types, toppings, sizePrice);                
    }
}