import java.awt.*;
import javax.swing.*;

/**
 * Demonstration program for simple simulation framework.
 * Create a couple of balls and let them wander around the screen.
 * Demonstrates model-view (without controller) design.
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
  public static void main(String[] args) {
    // Create the simulation model and populate it
    SimModel balls = new SimModel(viewSize, viewSize);
    balls.add(new Ball(50, 60, 3, -3, Color.red, 12, balls));
    balls.add(new Ball(150, 150, -5, -5, Color.green, 15, balls));

    // Create a graphics view,  put it in a window, and show it
    JFrame frame = new JFrame("Ball demo");
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    BallGraphicsView view = new BallGraphicsView(balls);
    view.setPreferredSize(new Dimension(viewSize, viewSize));
    frame.getContentPane().add(view);
    frame.pack();
    frame.setVisible(true);
    
    // Connect the view to the simulation and let it run
    balls.addView(view);
    balls.go(cyclesToRun); 
  }
}
