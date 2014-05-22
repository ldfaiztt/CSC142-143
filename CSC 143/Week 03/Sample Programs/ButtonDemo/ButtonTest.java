import java.awt.*;
import javax.swing.*;
/**
 * Main 'test' class for a simple JButton demonstration.
 * Original from CSE 143, Sp03.
 * 
 * @author Hal Perkins
 * @version 4/17/03; mod 1/22/05, vo 
 */ 
public class ButtonTest {
  /**
   * Create a new window with a ButtonDemo panel.
   */
  public static void main( String[] args ) {
    // Create new window and set it to dispose itself when closed
    JFrame frame = new JFrame( "Button Demo" );
    frame.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
    
    // Add a new ButtonDemo to the window and make it visible
    frame.getContentPane( ).add( new ButtonDemo( ), BorderLayout.CENTER );
    frame.pack( );
    frame.setVisible( true );
  }
}