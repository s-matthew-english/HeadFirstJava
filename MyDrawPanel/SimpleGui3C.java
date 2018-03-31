import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleGui3C implements ActionListener {

  JFrame frame;

  public static void main(String[] args) {
    SimpleGui3C gui = new SimpleGui3C();
    gui.go();
  }

  public void go() {
    frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JButton button = new JButton("Change colors");
    button.addActionListener(this);

    MyDrawPanel drawPanel = new MyDrawPanel();

    frame.getContentPane().add(BorderLayout.SOUTH, button);
    frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
    frame.setSize(300, 300);
    frame.setVisible(true);
  }

  public void actionPerformed(ActionEvent event) {
    frame.repaint();
  }
}

class MyDrawPanel extends JPanel {

  public void paintComponent(Graphics g) {

   /**
    * Fill the entire panel with black (the default color).
    */
    g.fillRect(0, 0, this.getWidth(), this.getHeight());
   /**
    * The first two args define the (x, y) upper left corner, relative to the
    * panel, for where drawing starts, so 0, 0 means "start 0 pixels from the 
    * left edge and 0 pixels from the top edge". The other two args say, "make
    * the width of this rectangle as wide as the panel (this.width()), and make
    * the height as tall as the panel (this.height)".
    */

    int red = (int)(Math.random() * 256);
    int green = (int)(Math.random() * 256);
    int blue = (int)(Math.random() * 256);

   /**
    * You can make a color by passing in 3 ints to represent the RGB value.
    */
    Color randomColor = new Color(red, green, blue);
    g.setColor(randomColor);
   /**
    * Start 70 pixels from the left, 70 from the top, make it 100 pixels wide, and 100 pixels tall.
    */
    g.fillOval(70, 70, 100, 100);
  }
}
