import java.awt.*;
import javax.swing.*;
import java.awt.geom.*; // required only for Shape tools used with Graphics2D 

/** 
 * Super simple demonstration of Swing graphics.  
 * Original by Hal Perkins, CSE143, Sp04.
 * Modified 1/16/05, including addition of Graphics2D demo.
 * Does not address thread safety.
 * @author CSC 143, VO
 * @version 1/16/05
 */
public class TestPanel extends JPanel {
  
  /** 
   * Paint a red oval in the upper-left corner of the panel.
   * Two different versions of this method are provided -- 
   * one that makes use of the Graphics2D capabilities, and 
   * one that uses the older Graphics class.  You may do 
   * your graphics either way in this course. 
   * 
   * You can try both versions, but make sure that one 
   * version is always commented out in order to compile.
   */
  public void paintComponent( Graphics g ) { // Graphics version
    super.paintComponent( g );
    g.setColor( Color.red );
    g.fillOval( 0, 0, 50, 50 );
  }
  
//  public void paintComponent( Graphics g ) { // Graphics2D version
//    super.paintComponent( g );
//    Graphics2D g2 = (Graphics2D)g;
//    g2.setPaint( Color.red );
//    g2.fill( new Ellipse2D.Double( 0, 0, 50, 50 ) );
//  }
  
  /** 
   * Demonstrate TestPanel.  This can be done by typing
   * "java TestPanel" in DrJava's interactions window
   * or any other command-line environment.  Closing 
   * the frame will reset the interactions, and vice versa.
   */
  public static void main(String[] args) {
    JFrame frame = new JFrame("Test Panel Window");
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    TestPanel panel = new TestPanel();
    panel.setPreferredSize(new Dimension(200,200));
    frame.getContentPane().add(panel);
    frame.pack();
    frame.setVisible(true);
  }
}