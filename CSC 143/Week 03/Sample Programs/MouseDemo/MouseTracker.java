import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * MouseTracker is a simple panel that reports mouse events that
 * occur on it.  All events are reported by writing an approprate
 * console message, and dragging events result in drawing on the pane.
 * Original from CSE 143, Au01, Sp03.
 * 
 * @author Hal Perkins
 * @version 10/20/01, 4/17/03; mod 1/22/05, vo
 */
public class MouseTracker extends JPanel 
  implements MouseListener, MouseMotionListener {
  
  // instance variables
  private int prevx, prevy;       // mouse coordinates before current event
  private int lastx, lasty;       // mouse coordinates from current event
  private boolean dragging;       // true if the last event was a drag event
  
  /** Constructor - register this object to listen for 
   * mouse events that occur on it */
  public MouseTracker( ) {
    super( );
    addMouseListener( this );  // This class serves as its own listener
    addMouseMotionListener( this );
    prevx = prevy = 0;
    lastx = lasty = 0;
    dragging = false;
  }
  
  // report event kind and update coordinates
  private void report( String whatHappened, MouseEvent e ) {
    prevx = lastx;
    prevy = lasty;
    lastx = e.getX( );
    lasty = e.getY( );
    dragging = false;

    // comment out the following statement to improve "drag & draw"
    System.out.println( whatHappened + " x = " + lastx + " y = " + lasty );
  }
  
  // Methods in MouseListener
  
  public void mouseClicked( MouseEvent e ) {
    report( "clicked", e );
  }
  
  public void mouseEntered( MouseEvent e ) {
    report( "entered", e );
  }
  
  public void mouseExited( MouseEvent e ) {
    report( "exited", e );
  }
  
  public void mousePressed( MouseEvent e ) {
    report( "pressed", e );
  }
  
  public void mouseReleased( MouseEvent e ) {
    report( "released", e );
    dragging = false;
  }
  
  // events in MouseMotionListener
  
  public void mouseDragged( MouseEvent e ) {
    report( "dragged", e );
    dragging = true;
    repaint( );
  }
  
  public void mouseMoved(MouseEvent e) {
    report( "moved", e );
  }
  
  /** 
   * If we are dragging, paint a line segment from the last position
   * to the current one.
   */
  public void paintComponent( Graphics g ) {
    // don't erase the previous contents of the window,
    // just draw a line segment
    if ( dragging ) {
      g.drawLine( prevx, prevy, lastx, lasty );
    }
  }
  
}
