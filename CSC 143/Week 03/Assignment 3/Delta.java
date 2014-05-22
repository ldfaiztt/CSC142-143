/**
 * A Delta is constructed by a apex and height. This class extends AbstractShape class
 * and contains methods that can only be used by shape Delta.
 * @author Chun-Wei Chen
 * @version 01/31/12
 */
public class Delta extends AbstractShape
{
  private int apexX; // the x-coordinate of the apex (the topmost point of Delta)
  private int apexY; // the y-coordinate of the apex
  
  /**
   * Constructs a Delta with apex at (x, y) and height h.
   * @param x the x-coordinate of the apex
   * @param y the y-coordinate of the apex
   * @param h the height of the Delta
   * @throws IllegalArgumentException if h < 0
   */
  public Delta(int x, int y, int h) {
    if (h < 0 || h % 2 == 1)
      throw new IllegalArgumentException("Height must be a positive even integer.");
    
    // While constructing a new Delta, move the location of upper left corner
    // from default (0, 0) to (x - r, y - r), which is the new location of
    // bounding box's upper left corner of the Delta should be.
    super.moveTo(x - h / 2, y);
    apexX = x;
    apexY = y;
    height = h; // Change the height from default value 10 to h.
  }

  /**
   * Returns true if the point (x, y) is on the Delta.
   * @param x x-coordinate of the point
   * @param y y-coordinate of the point
   * @return true if the point (x, y) is on the Delta
   */
  public boolean isOn(int x, int y) {
    // Determine by using the bounding box and the two equations of lines.
    return (x >= apexX - height / 2 && x <= apexX + height / 2 &&
            y >= apexY && y <= apexY + height) && ((2 * x + y >= 2 * apexX + apexY) &&
            (2 * x - y <= 2 * apexX - apexY));
  }
  
  /**
   * Moves the Delta from initial apex to the specified point.
   * @param newX the x-coordinate of new apex
   * @param newY the y-coordinate of new apex
   */
  public void moveTo(int newX, int newY) {
    // While moving the Delta, move the location of upper left corner as well.
    shiftBy(newX - apexX, newY - apexY);
  }
  
  /**
   * Shifts the Delta by a specified amount.
   * @param deltaX the difference between the initial x-coordinate and the new x-coordinate
   * @param deltaY the difference between the initial y-coordinate and the new y-coordinate
   */
  public void shiftBy(int deltaX, int deltaY) {
    // While shifting the Delta, shift the location of upper left corner as well.
    super.shiftBy(deltaX, deltaY);
    apexX += deltaX;
    apexY += deltaY;
  }
  
  /**
   * String representation of this Delta, including the location of apex and height.
   * @return String representation of this Delta
   */
  public String toString() {
    return "This is a Delta with apex at (" + apexX + ", " + apexY + ") " + 
           "and height " + height + ".";
  }
  
  /**
   * Tests if constructur and methods work fine.
   * @param args
   */
  public static void main(String args[]) {
    Delta d1 = new Delta(30, 20, 10);
    System.out.println(d1);
    System.out.println(d1.isOn(27, 26));
    System.out.println(d1.isOn(32, 23));
    System.out.println("The upper left corner of the bounding box of d1 is " +
                       "(" + d1.upperLeftX + ", " + d1.upperLeftY + ").");
    d1.moveTo(31, 20);
    System.out.println(d1);
    System.out.println(d1.isOn(27, 26));
    System.out.println(d1.isOn(32, 23));
    System.out.println("The upper left corner of the bounding box of d1 is " +
                       "(" + d1.upperLeftX + ", " + d1.upperLeftY + ").");
    
    Delta d2 = new Delta(10, 20, 30);
    System.out.println(d2);
    System.out.println(d2.isOn(-4, 48));
    System.out.println(d2.isOn(17, 32));
    System.out.println("The upper left corner of the bounding box of d1 is " +
                       "(" + d2.upperLeftX + ", " + d2.upperLeftY + ").");
    d2.shiftBy(30, 10);
    System.out.println(d2);
    System.out.println(d2.isOn(-4, 48));
    System.out.println(d2.isOn(17, 32));
    System.out.println("The upper left corner of the bounding box of d1 is " +
                       "(" + d2.upperLeftX + ", " + d2.upperLeftY + ")."); 
  }
}