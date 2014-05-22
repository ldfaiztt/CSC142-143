import java.awt.*;

/**
 * Basic interface for objects in the simple simulation world.
 * Any object that implements this can be added to the simulation.
 *
 * CSE143 demo, Au01, Sp03
 * 
 * @author Hal Perkins
 * @version 10/18/01, 4/16/03
 */

public interface SimThing {
  /**
   * Perform desired action for one simulation cycle.
   */
  public void action( );
  
  /**
   * Draw graphical representation of this SimThing.
   * @param g Graphics context where the drawing should occur
   */
  public void paintComponent( Graphics g );
}
