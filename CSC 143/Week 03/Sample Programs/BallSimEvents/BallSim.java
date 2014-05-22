import java.awt.*;
import javax.swing.*;

/**
 * Demonstration program for simple simulation framework.
 * Second version with user event handling to control the simulation.
 * 
 * @author Hal Perkins 
 * @version 10/18/01, 4/16/03, 10/13/03, 4/12/04
 */
public class BallSim {
  
  private static final int viewSize = 300;      // size of square viewer pane
  private static final int cyclesToRun = 1000;  // how many cycles to run
  
  /** 
   * Create window, viewer, and balls and run simulation
   */
  public static void main( String[] args ) {
    // Create the simulation model and populate it
    SimModel balls = new SimModel( viewSize, viewSize );
    balls.add( new Ball( 50, 60, 3, -3, Color.red, 12, balls ) );
    balls.add( new Ball( 150, 150, -5, -5, Color.green, 15, balls ) );

    // Create the controller/viewer,  put it in a window, and show it
    JFrame frame = new JFrame( "Ball demo" );
    frame.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
    BallSimControl controller = new BallSimControl( balls );
    frame.getContentPane( ).add( controller );
    frame.pack( );
    frame.setVisible( true );
    
    // let it run
    balls.go( cyclesToRun );
    
  }
}
