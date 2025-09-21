package lab05_handout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

// TODO: ChangeListner 추가 및 구현
public class TipCalculator extends JFrame implements ChangeListener{


    private JPanel contentPane;
    private JTextField amountText;
    private JTextField totalText;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        TipCalculator tc = new TipCalculator();
        tc.setVisible(true);
    }

    // TODO: ChangeListener에 해당하는 구현
    @Override
    public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider) e.getSource();
        if(!source.getValueIsAdjusting()){
            int value = (int) source.getValue();
            int amount = Integer.parseInt(amountText.getText());
            int total = (int) ((1 + (value * 0.01)) * amount);
            totalText.setText(String.valueOf(total));
        }
    }

    public TipCalculator() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 385, 246);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel titleLabel = new JLabel("TIP 계산기");
        titleLabel.setBounds(131, 28, 303, 35);
        titleLabel.setFont(new Font("맑은고딕", Font.BOLD, 18));
        contentPane.add(titleLabel);

        JLabel amountLabel = new JLabel("금액");
        amountLabel.setFont(new Font("맑은고딕", Font.PLAIN, 15));
        amountLabel.setBounds(35, 73, 89, 28);
        contentPane.add(amountLabel);

        amountText = new JTextField();
        amountText.setBounds(81, 73, 232, 30);
        contentPane.add(amountText);
        amountText.setColumns(10);

        JLabel tipLabel = new JLabel("팁");
        tipLabel.setFont(new Font("맑은고딕", Font.PLAIN, 15));
        tipLabel.setBounds(45, 111, 89, 28);
        contentPane.add(tipLabel);

        JSlider slider = new JSlider();
        slider.setMaximum(30);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.setMinorTickSpacing(1);
        slider.setValue(20);
        slider.setMajorTickSpacing(10);
        slider.setBounds(81, 115, 232, 37);
        contentPane.add(slider);
        // TODO: ChangeListener 추가
        slider.addChangeListener(this);

        JLabel totalLabel = new JLabel("총액");
        totalLabel.setFont(new Font("맑은고딕", Font.PLAIN, 15));
        totalLabel.setBounds(35, 160, 89, 28);
        contentPane.add(totalLabel);

        totalText = new JTextField();
        totalText.setColumns(10);
        totalText.setBounds(81, 162, 232, 30);
        contentPane.add(totalText);
    }
}

