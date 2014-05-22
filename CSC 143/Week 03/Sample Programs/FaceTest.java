import java.awt.*;
import javax.swing.*;

/**
 * Demonstrate basic Java Swing graphics, JFrame default layout. 
 * Does not address thread safety.
 * CSE143 Au01, Sp03 demo
 * 
 * @author Hal Perkins, VO
 * @version 10/16/01, 4/14/03, 4/7/04; 1/17/05 by VO
 */
public class FaceTest {
  
  /** Create a window with a smiley face inside it */
  public static void main( String[] args ) {
    
    // create frame and give it a name; set it to automatically
    // dispose itself when the window is closed
    JFrame frame = new JFrame( "A Face" );
    frame.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
    Container cp = frame.getContentPane( );
    
    // Add the face and a label to the window.
    // setPreferredSize ensures the face will have the size we
    // want when the window is packed
    Face f = new Face( );
    f.setPreferredSize( new Dimension( 200, 200 ) );
    f.setBackground( Color.cyan );
    cp.add( f, BorderLayout.CENTER );
    JLabel jlbl = new JLabel( "Don't worry, be happy!", SwingConstants.CENTER );
    cp.add( jlbl, BorderLayout.SOUTH );
    
    // pack layout to component natural sizes, then display
    frame.pack( );
    frame.setVisible( true );
  }
}
