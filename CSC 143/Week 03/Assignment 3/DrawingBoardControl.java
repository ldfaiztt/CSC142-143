import java.awt.event.*;
import java.util.*;
import javax.swing.event.*;
import javax.swing.*;
/**
 * Controller of the DrawingBoard.
 * @author Chun-Wei Chen
 * @version 02/03/12
 */
public class DrawingBoardControl
  implements ActionListener, MouseListener, MouseMotionListener, ChangeListener
{
  private int x0, y0;            // mouse coordinates before the current event
  private int newX, newY;        // mouse coordinates after the current event
  private int size;              // size of the shape
  private String actionCommand;  // store the current action command
  private boolean drag;          // true if the last event is drag event
  private DrawingBoard dBoard;   // a DrawingBoard object
  private JSlider slider;        // a JSlider object
  private JLabel label;          // a JLabel object
  
  /**
   * Constructs a DrawingBoardControl object.
   * @param db a DrawingBoard object
   * @throws IllegalArgumentException if one of the arguments is null
   */
  public DrawingBoardControl(DrawingBoard db, JSlider js, JLabel jl) {
    if (db == null || js == null)
      throw new IllegalArgumentException("Argument cannot be null.");
    // Initialize instance variables.
    dBoard = db;
    slider = js;
    slider.addChangeListener(this);  // Let slider listen to ChangeListener. 
    label = jl;
    x0 = 0;
    y0 = 0;
    newX = 0;
    newY = 0;
    size = 50;
    actionCommand = "Circle";
    drag = false;
  }
  
  /**
   * Changes the value of size into slider's value
   * and changes the size value displayed.
   * @param e a ChangeEvent object
   */
  public void stateChanged(ChangeEvent e) {
    size = slider.getValue();
    label.setText("Size: " + size);
  }
  
  // Assigns the coordinate variables to the new coordinates and sets drag to false
  private void mouseAction(MouseEvent e) {
    x0 = newX;
    y0 = newY;
    newX = e.getX();
    newY = e.getY();
    drag = false;
  }
  
  /**
   * Changes the display when the mouse pressed on the window.
   * @param e a MouseEvent
   */
  public void mousePressed(MouseEvent e) {
    mouseAction(e);
    
    // User clicked the Circle button.
    if (actionCommand.equals("Circle")) {
      Circle c = new Circle(newX, newY, size);
      dBoard.add(c);
    }
    
    // User clicked the Delta button.
    else if (actionCommand.equals("Delta")) {
      int deltaSize = size;
      
      // Round the deltaSize to make it become a even number. 
      if (deltaSize % 2 == 1)
        deltaSize++;
      
      Delta d = new Delta(newX, newY, deltaSize);
      dBoard.add(d);
    }
    
    // User clicked the Tee button.
    else if (actionCommand.equals("Tee")) {
      int teeSize = size;
      
      // Round the teeSize to make it become a mutiple of 10.
      if (teeSize % 10 < 5)
        teeSize -= teeSize % 10;
      else
        teeSize += 10 - teeSize % 10;
      
      Tee t = new Tee(newX, newY, teeSize);
      dBoard.add(t);
    }
    
    // User clicked the Not Adding Shape button.
    else
      dBoard.findShapeContainsPoint(newX, newY);
  }
  
  /**
   * Changes the coordinates after the mouse is released.
   * @param e a MouseEvent
   */
  public void mouseReleased(MouseEvent e) {
    mouseAction(e);
    drag = false;
  }
  
  /**
   * Changes the display when the mouse cursor drags shapes.
   * @param e a MouseEvent
   */
  public void mouseDragged(MouseEvent e) {
    mouseAction(e);
    drag = true;
    // Let the user be able to move the shpae if the user clicked
    // not adding shape button and there is a selected shape.
    if (actionCommand.equals("Not Adding Shape") && dBoard.getSelectedShape() != null)
        dBoard.moveSelectedShape(newX - x0, newY - y0);
  }
  
   /**
   * Changes the coordinates after the mouse clicked on the window.
   * @param e a MouseEvent
   */
  public void mouseClicked(MouseEvent e) {
    mouseAction(e);
  }
  
  /**
   * Does nothing when the mouse cursor has been moved onto a
   * component but no buttons have been pushed.
   * @param e a MouseEvent
   */
  public void mouseMoved(MouseEvent e) { }
  
  /**
   * Does nothing when the mouse enters a component.
   * @param e a MouseEvent
   */
  public void mouseEntered(MouseEvent e) { }
  
   /**
   * Does nothing when the mouse exits a component.
   * @param e a MouseEvent
   */
  public void mouseExited(MouseEvent e) { }
  
  /**
   * Stores the string reprsentation of the ActionEvent.
   * @param e an ActionEvent
  */
  public void actionPerformed(ActionEvent e) {
    actionCommand = e.getActionCommand();
  }
}