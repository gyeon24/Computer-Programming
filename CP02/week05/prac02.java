package lab05_handout;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;

public class CarRepair extends JPanel implements ItemListener {
    JCheckBox[] buttons = new JCheckBox[4];
    String[] repairs = { "엔진 오일 교환", "자동 변속기 오일 교환", "에어컨 필터 교환", "타이어 교환"};
    int[] prices = { 45000, 80000, 30000, 100000 };
    int totalCost = 0;
    JLabel displayCost;

    public CarRepair() {
        for (int i = 0; i < 4; i++) {
            buttons[i] = new JCheckBox(repairs[i]);
			buttons[i].addItemListener(this);
            // 각 체크박스에 대한 이벤트처리기를 등록한다.
        }
        for (int i = 0; i < 4; i++)
            add(buttons[i]);
        displayCost = new JLabel("총 자동차 정비 비용은 "+ totalCost +"원입니다.");
        displayCost.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 20));
        add(displayCost);
    }

    public void itemStateChanged(ItemEvent e) {
        Object source = e.getItemSelectable();
        for (int i = 0; i < 4; i++) {
            if (source == buttons[i]) {
				// 체크박스가 선택된 경우 총 정비 비용에 선택된 정비 항목의 비용을 더한다.
                if (buttons[i].isSelected() == true){
                    totalCost += prices[i];
                }
				// 체크박스가 해제된 경우 총 정비 비용에서 선택된 정비 항목의 비용을 뺀다.
                else
                    totalCost -= prices[i];
                displayCost.setText("총 자동차 정비 비용은 "+ totalCost +"원입니다.");
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("자동차 정비 비용 계산");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JComponent newContentPane = new CarRepair();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);
        frame.setSize(500, 150);
        frame.setVisible(true);
    }
}