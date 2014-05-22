import javax.swing.*;
import java.awt.*;
/**
 * Test class to test the code from the 143 slides.
 * 
 * @author CSC 143
 * @version F'09
 */
public class TestGUI
{
  /**
   * Main method to create a simple Frame with
   * a panel and a label.  Comments show the 
   * 5 steps to include each time you create a window.
   */
  public static void main(String[] args)
  {
    // 1. Construct the window (JFrame)
    JFrame frame = new JFrame( "Trivial Window" ); //default layout: Border
    // 2. Set the default close operation.
    frame.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
    // 3. Put something in the window.  (Here we create 2 components 
    //    and add them to the JFrame's content pane.
    JPanel panel = new JPanel( );
    panel.setPreferredSize( new Dimension( 250, 250 ) );
    JLabel label = new JLabel( "Smile!" );
    label.setHorizontalAlignment( SwingConstants.CENTER );
    Container cp = frame.getContentPane( );
    cp.add( panel, BorderLayout.CENTER );
    cp.add( label, BorderLayout.SOUTH );
    // 4. Pack.
    frame.pack( ); 
    // 5. Set visible.
    frame.setVisible( true );
  }
}
