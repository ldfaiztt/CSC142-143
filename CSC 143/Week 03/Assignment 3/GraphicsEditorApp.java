import java.awt.*;
import javax.swing.*;
import java.util.*;
/**
 * This class hooks up the model, viewers and controller, and then displays them in
 * a window. User can create three kinds of shape (Circle, Delta, Tee) by selecting the
 * shape the user wants to add into the window and clicking on the window to specify the
 * location of the shape.
 * @author Chun-Wei Chen
 * @version 02/03/12
 */
public class GraphicsEditorApp
{
  /**
   * Creates window, viewer, and the shapes in DrawingBoard's shapeList.
   * @param args
   */
  public static void main(String[] args) {
    // Create a DrawingBoard object and add some shapes
    DrawingBoard dBoard = new DrawingBoard();
    dBoard.add(new Tee(50, 50, 50));
    dBoard.add(new Delta(50, 40, 40));
    
    // Construct the window
    JFrame frame = new JFrame("Graphics Editor");
    
    // Set the default close operation
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    
    // Register 2 viewers to the DrawingBoard object
    DrawingBoardTextDisplay tDisp = new DrawingBoardTextDisplay(dBoard);
    DrawingBoardGraphicDisplay gDisp = new DrawingBoardGraphicDisplay(dBoard);
    // Set the size of the panel and put it on JFrame
    gDisp.setPreferredSize(new Dimension(400, 400));
    frame.getContentPane().add(gDisp, BorderLayout.CENTER);
    frame.getContentPane().add(tDisp, BorderLayout.SOUTH);
    
    // Lay out components and resize window to fit
    frame.pack();
    
    // Let the window become visible
    frame.setVisible(true);
  }
}