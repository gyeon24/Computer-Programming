package lab06_handout.handout;

import javax.swing.*;
import java.awt.*;

class BusinessCard extends JPanel {
  Image img;
  Font f;
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    f = new Font("SanSerif",Font.BOLD, 15);
    g.setFont(f);
    // 텍스트의 폰트를 지정하는 코드를 추가한다.
    g.drawString("차차", 150, 50);
	g.drawString("학부생", 150,80);
    g.drawString("충남대학교",150,110);
    // 여기에 직책과 소속을 표시하는 코드를 추가한다.
    img = new ImageIcon("src/lab06_handout/hw_handout/chacha.png").getImage();
    g.drawImage(img,50,30,null);
	// 자신의 사진(또는 임의의 그림)을 가져와서 이미지 객체를 만든다.
	// 이미지를 텍스트 왼쪽에 추가하는 코드를 작성한다.
	// 힌트: Graphics 클래스의 drawImage() 메소드를 사용한다.
  }
}
public class MyBusinessCard extends JFrame{
  public MyBusinessCard()
  {
    setSize(400,180);
    setTitle("My Business Card");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    add(new BusinessCard());
    setVisible(true);
  }
  public static void main(String[] arge) { new MyBusinessCard(); }
}


