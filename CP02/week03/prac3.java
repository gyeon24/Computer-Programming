package lab03_handout;

import javax.swing.*;
import java.awt.*;

public class ImageViewer {
    public static void main(String[] args) {
        JPanel panel1, panel2;
        JLabel label;
        JButton button1, button2, button3, button4;
        JFrame imageViewer = new JFrame("Image Viewer");

        imageViewer.setTitle("Image Viewer");
        imageViewer.setSize(400, 250);

        panel1 = new JPanel();
        panel2 = new JPanel();
        label = new JLabel("");

        ImageIcon icon = new ImageIcon("d://dog.jpg");
		// 소스코드와 같은 폴더에 있는 이미지 파일(dog.jpg)에 대한 ImageIcon 객체(icon)를 생성한다.
		
        label.setIcon(icon);
        panel2.add(label);
        button1 = new JButton("<<");
        button2 = new JButton("<");
        button3 = new JButton(">");
        button4 = new JButton(">>");

        panel1.add(button1);
        panel1.add(button2);
        panel1.add(button3);
        panel1.add(button4);

        imageViewer.add(panel2, BorderLayout.CENTER);
		
		// 여기에 버튼들의 패널 panel1을 imageViewer 프레임에 추가하는 코드를 작성한다.
		imageViewer.add(panel1, BorderLayout.SOUTH);

        imageViewer.setVisible(true);
        imageViewer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
