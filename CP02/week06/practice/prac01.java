package lab06_handout.handout;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

class HousePanel extends JPanel {
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    g2.setStroke(new BasicStroke(3));
    g2.setColor(Color.BLACK);
    g2.draw(new Rectangle2D.Float(50,50,200,140));
    g2.draw(new Line2D.Float(150, 20, 50, 50));
    g2.draw(new Line2D.Float(150, 20, 250,50));
    g2.draw(new Rectangle2D.Float(70,70,20,20));
    g2.draw(new Rectangle2D.Float(150,80,50,100));
    g2.draw(new Line2D.Float(250,50,250,20));
    g2.draw(new Line2D.Float(250,20,210,20));
    g2.draw(new Line2D.Float(210,20,210,35));
  }
}

public class DrawHouse extends JFrame{
  public DrawHouse()
  {
    setSize(600,250);
    setTitle("Draw House");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    HousePanel myHouse = new HousePanel();
    myHouse.setBounds(0, 0, 300, 300);
    add(myHouse);
    setVisible(true);
  }
  
  public static void main(String[] arge)
  {
    DrawHouse f = new DrawHouse();
  }
}

