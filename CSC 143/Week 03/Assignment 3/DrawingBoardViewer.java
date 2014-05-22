/**
 * A interface for the viewers of a DrawingBoard. A DrawingBoardViewer can be
 * registered with a DrawingBoard so that it will be notified after the changes
 * occur in the model in order to update the display.
 * @author Chun-Wei Chen
 * @version 02/02/12
 */
public interface DrawingBoardViewer
{
  /**
   * Notifies the DrawingBoardViewer so it can update the display.
   */
  public void shapeListChanged();
}