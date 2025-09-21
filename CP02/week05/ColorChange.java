package lab05_handout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorChange extends JFrame  implements ActionListener{

    private JPanel contentPane;
    JPanel panel;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        ColorChange cc = new ColorChange();
        cc.setVisible(true);
    }

    public ColorChange() {
        setTitle("배경색 변경");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));

        setContentPane(contentPane);
        // TODO: 콤보박스 추가
        String[] colors = {"Red", "Green", "Blue", "Yellow"};
        JComboBox comboBox = new JComboBox(colors);
        comboBox.addActionListener(this);


        contentPane.add(comboBox, BorderLayout.NORTH);

        panel = new JPanel();
        panel.setBackground(Color.red);
        contentPane.add(panel, BorderLayout.CENTER);
    }
    public void actionPerformed(ActionEvent e) {
        // TODO: 버튼입력을 확인하여 panel Background 색 변경
        JComboBox cb = (JComboBox) e.getSource();
        String name = (String) cb.getSelectedItem();
        if( "Red".equals(name) ) panel.setBackground(Color.RED);
        else if("Blue".equals(name)) panel.setBackground(Color.BLUE);
        else if("Green".equals(name)) panel.setBackground(Color.GREEN);
        else if("Yellow".equals(name)) panel.setBackground(Color.YELLOW);
    }
}
