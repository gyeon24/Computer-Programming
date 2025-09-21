package practice.handout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeListener;

public class MoveCarGame extends JFrame {
    int img_x = 50, img_y = 50;
    public MoveCarGame() {
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel carPanel = new JPanel();
        JButton carButton = new JButton(new ImageIcon("src/practice/handout/images/car.png"));

        carPanel.setLayout(null);
        carButton.setLocation(img_x, img_y);
        carButton.setSize(200, 100);
        carPanel.add(carButton);
        carPanel.requestFocus();
        carPanel.setFocusable(true);
		
		// 무명클래스를 이용하여 KeyListerner를 구현하는 아래 코드를 
		// KeyAdapter 클래스를 사용하는 방법으로 바꾸어 보시오.

        class KeyAdapter implements KeyListener{
            public void keyPressed(KeyEvent e) {
                int keycode = e.getKeyCode();
                switch (keycode) {
                    case KeyEvent.VK_UP:	img_y -= 10;	break;
                    case KeyEvent.VK_DOWN:	img_y += 10;	break;
                    case KeyEvent.VK_LEFT:	img_x -= 10;	break;
                    case KeyEvent.VK_RIGHT:	img_x += 10;	break;
                }
                carButton.setLocation(img_x, img_y);
            }
            public void keyReleased(KeyEvent arg0) {}
            public void keyTyped(KeyEvent arg0) {}
        }

        add(carPanel);

        JPanel buttonPanel = new JPanel();
        JButton leftButton = new JButton("LEFT");
		
		// 아래 무명클래스를 이용하여 구현된 액션리스너를 람다식으로 바꾸어 보시오.
        leftButton.addActionListener(e ->  {
				img_x -= 10;
				carButton.setLocation(img_x, img_y);
        });
        JButton rightButton = new JButton("RIGHT");

        rightButton.addActionListener(new Action() {
            @Override
            public Object getValue(String key) {
                return null;
            }
            @Override
            public void putValue(String key, Object value) {
            }
            @Override
            public void setEnabled(boolean b) {
            }
            @Override
            public boolean isEnabled() {
                return false;
            }
            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {
            }
            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {
            }
            @Override

            //leftButton.addActionListener(e -> {
            //    img_x -= 10;
            //    carButton.setLocation(img_x, img_y);
            //});
            //
            //rightButton.addActionListener(e -> {
            //    img_x += 10;
            //    carButton.setLocation(img_x, img_y);
            //});

            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == leftButton) {
                    img_x -= 10;
                    carButton.setLocation(img_x, img_y);
                } else if(e.getSource() == rightButton){
                    img_x += 10;
                    carButton.setLocation(img_x, img_y);
                }

            }
        });
        buttonPanel.add(leftButton);
        buttonPanel.add(rightButton);
        add(buttonPanel, "South");

        setVisible(true);
    }

    public static void main(String[] args) {
        MoveCarGame s = new MoveCarGame();
    }
}
