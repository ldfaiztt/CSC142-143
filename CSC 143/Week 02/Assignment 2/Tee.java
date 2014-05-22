/**
 * A Tee is constructed by upper left corner and height. This class extends
 * AbstractShape class and contains methods that can only be used by shape Tee.
 * @author Chun-Wei Chen
 * @version 01/19/12
 */
public class Tee extends AbstractShape
{
  /**
   * Constructs a Tee with upper left corner at (x, y) and height h.
   * @param x the x-coordinate of the upper left corner
   * @param y the y-coordinate of the upper left corner
   * @param h the height of the Tee
   * @throws IllegalArgumentException if h < 0 or h is not a multiple of 10
   */
  public Tee(int x, int y, int h) {
    if (h < 0 || h % 10 != 0)
      throw new IllegalArgumentException("Height must be a multiple of 10, " + 
                                         "positive integer.");
    
    // While constructing a new Tee, move the location of upper left corner
    // from default (0, 0) to (x - r, y - r), which is the new location of
    // bounding box's upper left corner of the Tee should be.
    moveTo(x, y);
    height = h; // Change the height from default value 10 to h.
  }
  
  /**
   * Returns true if the point (x, y) is on the Tee.
   * @param x x-coordinate of the point
   * @param y y-coordinate of the point
   * @return true if the point (x, y) is on the Tee
   */
  public boolean isOn(int x, int y) {
    // Determine by using the boundary of two rectangles.
    return (x >= upperLeftX && x <= upperLeftX + height &&
            y >= upperLeftY && y <= upperLeftY + height / 5) ||
           (x >= upperLeftX + 2 * height / 5 &&
            x <= upperLeftX + 3 * height / 5 &&
            y >= upperLeftY + height / 5 && y <= upperLeftY + height);
  }
  
  /**
   * String representation of this Tee, including the location of
   * the upper left corner and height.
   * @return String representation of this Tee
   */
  public String toString() {
    return "This is a Tee with the upper left corner point (" + upperLeftX + ", " +
           upperLeftY + ") and height " + height;
  }
  
  /**
   * Tests if constructur and methods work fine.
   * @param args
   */
  public static void main(String args[]) {
    Tee t1 = new Tee(25, 20, 20);
    System.out.println(t1);
    System.out.println(t1.isOn(33, 24));
    System.out.println(t1.isOn(33, 41));
    System.out.println("The upper left corner of the bounding box of t1 is " +
                       "(" + t1.upperLeftX + ", " + t1.upperLeftY + ").");
    t1.moveTo(25, 21);
    System.out.println(t1);
    System.out.println(t1.isOn(33, 24));
    System.out.println(t1.isOn(33, 41));
    System.out.println("The upper left corner of the bounding box of t1 is " +
                       "(" + t1.upperLeftX + ", " + t1.upperLeftY + ").");
    
    Tee t2 = new Tee(-10, -10, 10);
    System.out.println(t2);
    System.out.println(t2.isOn(0, 0));
    System.out.println(t2.isOn(-4, 0));
    System.out.println("The upper left corner of the bounding box of t2 is " +
                       "(" + t2.upperLeftX + ", " + t2.upperLeftY + ").");
    t2.shiftBy(4, 8);
    System.out.println(t2);
    System.out.println(t2.isOn(0, 0));
    System.out.println(t2.isOn(-4, 0));
    System.out.println("The upper left corner of the bounding box of t2 is " +
                       "(" + t2.upperLeftX + ", " + t2.upperLeftY + ").");
  }
}