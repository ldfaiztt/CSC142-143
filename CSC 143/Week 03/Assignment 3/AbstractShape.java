/**
 * This class implements Shape interface and provides default implementation
 * that can be used by all kinds of Shape.
 * @author Chun-Wei Chen
 * @version 01/19/12
 */
public abstract class AbstractShape implements Shape
{
  protected int upperLeftX; // upper left corner's x-coordinate of this Shape on DrawingBoard
  protected int upperLeftY; // upper left corner's y-coordinate of this Shape on DrawingBoard
  protected int height;
  private java.awt.Color color;
  private boolean selected; // the attribute to determine whether the shape is selected
  
  /**
   * Sets default values for every Shape.
   */
  public AbstractShape() {
    upperLeftX = 0;
    upperLeftY = 0;
    height = 10;
    color = new java.awt.Color(255, 255, 255);
    selected = false;
  }
  
  /**
   * Returns true if the point (x, y) is on the Shape.
   * @param x the x-coordinate of the point
   * @param y the y-coordinate of the point
   * @return true if the point (x, y) is on the Shape
   */
  public abstract boolean isOn(int x, int y);
  
  /**
   * Sets this Shape to be selected.
   * @param b true to set this Shape to be selected
   */
  public void setSelected(boolean b) {
    selected = b;
  }
  
  /**
   * Returns true if this Shape is selected.
   * @return true if this Shape is selected
   */
  public boolean isSelected() {
    return selected;
  }
  
  /**
   * Sets the Color of the Shape.
   * @param c the new Color for the Shape
   * @throws IllegalArgumentException if c is null
   */
  public void setColor(java.awt.Color c) {
    if (c == null)
      throw new IllegalArgumentException("Argument cannot be null.");
    color = c;
  }
  
  /**
   * Returns the Color of the Shape.
   * @return the Color of the Shape
   */
  public java.awt.Color getColor() {
    return color;
  }
  
  /**
   * Shifts the Shape by a specified amount.
   * @param deltaX the difference between the initial x-coordinate and the new x-coordinate
   * @param deltaY the difference between the initial y-coordinate and the new y-coordinate
   */
  public void shiftBy(int deltaX, int deltaY) {
    upperLeftX += deltaX;
    upperLeftY += deltaY;
  }
  
  /**
   * Moves the Shape to the specified point.
   * @param newX the new x-coordinate of the Shape
   * @param newY the new y-coordinate of the Shape
   */
  public void moveTo(int newX, int newY) {
    upperLeftX = newX;
    upperLeftY = newY;
  }
}