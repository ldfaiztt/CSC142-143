import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

/**
 * Viewer/controller for ball world simulation.
 * This panel contains the view plus buttons and mouse input controllers
 * that allow the user to pause and stop the simulation, and add new
 * objects to the simulation.
 * @author Hal Perkins 
 * @version 10/20/01, 4/18/03, 4/19/04
 */
public class BallSimControl extends JPanel {
  
  // instance variables
  private BallGraphicsView viewPane;         // the panel with the bouncing balls
  private SimModel world;                    // the simulation world
  private SimButtonListener buttonListener;  // listener object for buttons
  private SimMouseListener  mouseListener;   // listener object for mouse clicks
  
  /**
   * Construct a viewer/controller for the given world
   * @param w the model object this BallSimControl object is controlling 
   *              and viewing
   */
  public BallSimControl( SimModel w ) {
    
    // capture model
    world = w;
   
    // default layout manager for JPanel is flow layout - we want border layout
    setLayout( new BorderLayout( ) );
    
    // create pane with ball display and place it in the center
    viewPane = new BallGraphicsView( world );
    viewPane.setPreferredSize( new Dimension( world.getWidth( ), world.getHeight( ) ) );
    add( viewPane, BorderLayout.CENTER );
    
    // register the view with the model
    world.addView( viewPane );
        
    // set up listener for mouse clicks on the view
    mouseListener = new SimMouseListener( world );
    viewPane.addMouseListener( mouseListener );
 
    // create panel with start/stop buttons and add it at the bottom
    JButton pause = new JButton( "pause" );
    JButton resume = new JButton( "resume" );
    JButton stop = new JButton( "stop" );
    JPanel buttons = new JPanel( );
    buttons.add( pause );
    buttons.add( resume );
    buttons.add( stop );
    pause.setBackground( Color.yellow );
    resume.setBackground( Color.green );
    stop.setBackground( Color.red );
    buttons.setBackground( Color.lightGray );
    this.add( buttons, BorderLayout.SOUTH );
    
    // set up listener for the buttons
    buttonListener = new SimButtonListener( world );
    pause.addActionListener( buttonListener );
    resume.addActionListener( buttonListener );
    stop.addActionListener( buttonListener );
  }
  
}


/**
 * Handle button clicks for the BallSimControl window.
 * 
 * @author Hal Perkins 
 * @version 10/20/01, 4/18/03, 4/19/04
 */
class SimButtonListener implements ActionListener {
  // instance variables
  private SimModel world; // the SimModel we are controlling
  
  /**
   * Constructor for objects of class SimButton
   * @param world the model object of the simulation
   */
  public SimButtonListener( SimModel world ) {
    this.world = world;
  }

  /**
   * Process button clicks by turning the simulation on and off
   * @param e the event created by the button click
   */
  public void actionPerformed( ActionEvent e ) {
    if ( e.getActionCommand( ).equals( "pause" ) ) {
      world.pause( );
    } else if ( e.getActionCommand( ).equals( "resume" ) ) {
      world.resume( );
    } else if ( e.getActionCommand( ).equals( "stop" ) ) {
      world.stop( );
    }
  }
}

/**
 * Handle mouse clicks for the BallSimControl window.
 * 
 * @author Hal Perkins 
 * @version 4/18/03, 4/19/94
 */
class SimMouseListener implements MouseListener {
  // instance variables
  private SimModel world; // the SimModel we are controlling
  private static Random random;

  
 /**
   * Constructor for objects of class SimMouseListener
   * @param world the model object containing the state of the system
   */
  public SimMouseListener( SimModel world ) {
    super( );
    this.world = world;
    
    // initialize random number sequence with system clock to get different
    // results each time.  Debugging hint: replace the parameter with a
    // constant to get the same sequence of numbers each time the program runs.
    random = new Random( System.currentTimeMillis( ) );
  }
  
  /**
   * Process mouse click by adding a new ball to the simulation at the location
   * of the click with a random color, size, and velocity
   * @param e the mouse click event
   */
  public void mouseClicked( MouseEvent e ) {
    world.add( randomBall( e.getX( ), e.getY( ) ) );
  }
  
  /**
   * Create a new ball with random color, size, and velocity
   * @param x initial x coordinate of the new ball
   * @param y initial y coordinate of the new ball
   */
  private Ball randomBall( int x, int y ) {
    return new Ball(x, y,
                    random.nextInt(21) - 11,       // dx
                    random.nextInt(21) - 11,       // dy
                    new Color(random.nextInt(256), // color
                              random.nextInt(256),
                              random.nextInt(256)),
                    random.nextInt(20) + 5,        // diameter
                    world);                        // model containing window size
  }

  // dummy implementations for other events in mouselistener
  public void mouseEntered ( MouseEvent e ) { }
  public void mouseExited  ( MouseEvent e ) { }
  public void mousePressed ( MouseEvent e ) { }
  public void mouseReleased( MouseEvent e ) { }
}
