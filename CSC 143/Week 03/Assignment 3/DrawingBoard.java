import java.util.*;
/**
 * This class keeps track of a list of Shapes user passed in and the selected shape, 
 * which will always be on top of the other shapes, It also keeps track of the 
 * interested viewers and notify the viewers when the changes occur.
 * @author Chun-Wei Chen
 * @version 02/03/12
 */
public class DrawingBoard
{
  private ArrayList<Shape> shapeList; // a list of Shapes
  
  // an ArrayList that keeps track of interested viewers
  private ArrayList<DrawingBoardViewer> viewers;
  
  /**
   * Constucts a DrawingBoard and initializes the shapeList and viewers.
   */
  public DrawingBoard() {
    shapeList = new ArrayList<Shape>();
    viewers = new ArrayList<DrawingBoardViewer>();
  }
  
  /**
   * Adds Shape to the DrawingBoard and makes this Shape becomes the selected shape.
   * @param s a Shape
   * @throws IllegalArgumentException if s is null
   */
  public void add(Shape s) {
    if (s == null)
      throw new IllegalArgumentException("Argument cannot be null.");
    // Set the added Shape become selected shape and
    // make the previous Shape become not selected shape.
    if (shapeList.size() > 0)
      shapeList.get(shapeList.size() - 1).setSelected(false);
    s.setSelected(true);
    shapeList.add(s);
    
    notifyAllViewer();
  }
  
  /**
   * Finds the topmost Shape that contains the point (x, y) and makes that Shape
   * become the selected shape. If no Shape contains the point (x,y), then no
   * Shape is the selected shape.
   * @param x x-coordinate of the point
   * @param y y-coordinate of the point
   */
  public void findShapeContainsPoint(int x, int y) {
    Shape a;
    // Find the selected shape from the end of the list.
    // Go through the ArrayList in the reverse direction.
    ListIterator<Shape> it = shapeList.listIterator(shapeList.size());
    while (it.hasPrevious()) {
      a = it.previous();
      // Find the topmost Shape which contains (x, y) and make it become selected shape.
      if (a.isOn(x, y)) {
        shapeList.remove(a);
        a.setSelected(true);
        shapeList.add(a);
        break;
      } else {
        // If the Shape dosen't contain (x, y), then it is not selected shape. 
        a.setSelected(false);
      }
    }
    notifyAllViewer();
  }
  
  /**
   * Returns the selected shape. If no Shape is currently selected, return null.
   * @return the selected shape; null if no Shape is currently selected
   */
  public Shape getSelectedShape() {
    if (shapeList.size() > 0) {
      Shape b = shapeList.get(shapeList.size() - 1);
      if (b.isSelected())
        return b;
    }
    return null;
  }
  
  /**
   * Removes the selected shape.
   * @throws IllegalStateException if no Shape is currently selected
   */
  public void removeSelectedShape() {
    if (getSelectedShape() == null)
      throw new IllegalStateException("No shape is currently selected.");
    if (shapeList.size() > 0) {
      shapeList.remove(shapeList.size() - 1);
      // Set the topmost Shape remaining in the ArrayList to be selected shape.
      // If no Shape is remaining, then no Shape is selected.
      if (shapeList.size() > 0)
        shapeList.get(shapeList.size() - 1).setSelected(true);
    }
    notifyAllViewer();
  }
  
  /**
   * Sets the Color of the selected shape.
   * @param c the new Color for the selected shape
   * @throws IllegalArgumentException if c is null
   * @throws IllegalStateException if no Shape is currently selected
   */
  public void setSelectedShapeColor(java.awt.Color c) {
    if (c == null)
      throw new IllegalArgumentException("Argument cannot be null.");
    if (getSelectedShape() == null)
      throw new IllegalStateException("No shape is currently selected.");
    getSelectedShape().setColor(c);
  }
  
  /**
   * Moves the selected shape by a specified amount.
   * @param changeInX the difference between the initial x-coordinate and new x-coordinate
   * @param changeInY the difference between the initial y-coordinate and new y-coordinate
   * @throws IllegalStateException if no Shape is currently selected
   */
  public void moveSelectedShape(int changeInX, int changeInY) {
    if (getSelectedShape() == null)
      throw new IllegalStateException("No shape is currently selected.");
    getSelectedShape().shiftBy(changeInX, changeInY);
    
    notifyAllViewer();
  }
  
  /**
   * Returns a copy of the ArrayList of Shapes in the DrawingBoard.
   * @return a copy of the ArrayList of Shapes in the DrawingBoard
   */
  public ArrayList<Shape> getShapeList() {
    return new ArrayList<Shape>(shapeList);
  }
  
  /**
   * Makes the viewers register with the DrawingBoard.
   * @param viewer a viewer of DrawingBoard
   * @throws IllegalArgumentException if viewer is null
   */
  public void addViewer(DrawingBoardViewer viewer) {
    if (viewer == null)
      throw new IllegalArgumentException("Argument cannot be null.");
    viewers.add(viewer);
  }
  
  // Notify all the viewer after the state changes.
  private void notifyAllViewer() {
    for (DrawingBoardViewer viewer : viewers)
      viewer.shapeListChanged();
  }
  
  /**
   * Tests if constructur and methods work fine.
   * @param args
   */
  public static void main(String args[]) {
    DrawingBoard dp = new DrawingBoard();
    dp.add(new Circle(20, 25, 10));
    dp.add(new Delta(20, 10, 10));
    dp.add(new Tee(16, 0, 10));
    System.out.println(dp.getShapeList());
    System.out.println(dp.getSelectedShape());
    dp.findShapeContainsPoint(20, 20);
    System.out.println(dp.getShapeList());
    System.out.println(dp.getSelectedShape().getColor());
    dp.setSelectedShapeColor(new java.awt.Color(0, 0, 0));
    System.out.println(dp.getSelectedShape().getColor());
    dp.moveSelectedShape(10, 10);
    System.out.println(dp.getSelectedShape());
    dp.findShapeContainsPoint(20, 20);
    System.out.println(dp.getShapeList());
    dp.removeSelectedShape();
    System.out.println(dp.getShapeList());
    dp.removeSelectedShape();
    System.out.println(dp.getShapeList());
    dp.removeSelectedShape();
    System.out.println(dp.getShapeList());
  }
}