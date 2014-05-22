/**
 * This interface contains all the basic methods that every shape should have.
 * @author Chun-Wei Chen
 * @version 01/19/12
 */
public interface Shape
{
  /**
   * Returns true if the point (x, y) is on the Shape.
   * @param x the x-coordinate of the point
   * @param y the y-coordinate of the point
   * @return true if the point (x, y) is on the Shape.
   */
  public boolean isOn(int x, int y);
  
  /**
   * Returns true if this Shape is selected.
   * @return true if this Shape is selected
   */
  public boolean isSelected();
  
  /**
   * Sets this Shape to be selected.
   * @param b true to set this Shape to be selected
   */
  public void setSelected(boolean b);
  
  /**
   * Sets the Color of the Shape.
   * @param c the new Color for the Shape
   */
  public void setColor(java.awt.Color c);
  
  /**
   * Returns the Color of the Shape.
   * @return the Color of the Shape
   */
  public java.awt.Color getColor();
  
  /**
   * Shifts the Shape by a specified amount.
   * @param deltaX the difference between the initial x-coordinate and the new x-coordinate
   * @param deltaY the difference between the initial y-coordinate and the new y-coordinate
   */
  public void shiftBy(int deltaX, int deltaY);
  
  /**
   * Moves the Shape to the specified point.
   * @param newX the new x-coordinate of the Shape
   * @param newY the new y-coordinate of the Shape
   */
  public void moveTo(int newX, int newY);
  
  /**
   * String representation of the Shape.
   * @return String representation of the Shape
   */
  public String toString();
}