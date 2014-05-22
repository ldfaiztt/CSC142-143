/**
 * Basic interface for viewers of a SimModel.  A SimView can be added
 * to a SimModel, which will periodically notify the SimView so it can
 * update its display after changes occur in the model.  
 *
 * CSE143 demo Au01, Sp03, Sp04
 * 
 * @author Hal Perkins 
 * @version 10/18/01, 4/16/03, 4/12/04
 */

public interface SimView {
  /**
   * Notify this SimView so it can update its display of the SimModel.
   */
  public void notifyViewer( );
}
