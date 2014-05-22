import java.awt.*;
import javax.swing.*;
import java.util.*;

/**
 * Main 'test' class for a simple mouse event demonstration.
 * CSE 143 demo, Au01, Sp03, Sp04
 * @author Hal Perkins 
 * @version 10/20/01, 4/17/03, 4/19/04; mod 1/22/05, vo
 */
public class MouseTest {

    /** Create a window with the mouse tracker pane in it and let it run */
    public static void main( String[] args ) {
        // create window & set it to dispose itself when closed
        JFrame frame = new JFrame( "Mouse Tracker" );
        frame.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        
        // add mouse tracker to it
        Container cp = frame.getContentPane( );
        MouseTracker mt = new MouseTracker( );
        mt.setBackground( Color.WHITE );
        mt.setPreferredSize( new Dimension( 300, 300 ) );
        cp.add( mt, BorderLayout.CENTER );

        // make window visible
        frame.pack( );
        frame.setVisible( true );
    }
    
}
