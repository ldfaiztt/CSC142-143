import javax.swing.*;
import java.awt.*;
/**
 * A text view version of the DrawingBoard.
 * @author Chun-Wei Chen
 * @version 02/02/12
 */
public class DrawingBoardTextDisplay extends JPanel implements DrawingBoardViewer
{
  private DrawingBoard dBoard; // a DrawingBoard object
  private JTextArea textDisplay; // a JTextArea object
  
  /**
   * Constructs a DrawingBoardTextDisplay and register it with the DrawingBoard
   * passed in. Shows the number of shapes and the selected shape in the DrawingBoard. 
   * @param db a DrawingBoard object
   * @throws IllegalArgumentException if db is null
   */
  public DrawingBoardTextDisplay(DrawingBoard db) {
    if (db == null)
      throw new IllegalArgumentException("Argument cannot be null.");
    dBoard = db;
    dBoard.addViewer(this);
    textDisplay = new JTextArea("There are " + dBoard.getShapeList().size() + " shapes " +
                                "on the DrawingBoard.\nSelected shape: \n" +
                                dBoard.getSelectedShape());
    add(textDisplay);
  }
  
  /**
   * Changes the text shown to the user after the changes occur in the model.
   */
  public void shapeListChanged() {
    repaint();
  }
  
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (dBoard.getSelectedShape() == null)
      textDisplay.setText("There are " + dBoard.getShapeList().size() + " shapes " +
                         "on the DrawingBoard.\nThere is no current selected shape.");
    else
      textDisplay.setText("There are " + dBoard.getShapeList().size() + " shapes " +
                         "on the DrawingBoard.\nSelected shape: \n" +
                         dBoard.getSelectedShape());
  }
}