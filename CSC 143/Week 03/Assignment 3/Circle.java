/**
 * A Circle is constructed by a center and radius. This class extends AbstractShape class
 * and contains methods that can only be used by shape Circle.
 * @author Chun-Wei Chen
 * @version 01/31/12
 */
public class Circle extends AbstractShape
{
  private int centerX, centerY, radius;
  
  /**
   * Constructs a Circle centered at (x, y) with radius r.
   * @param x x-coordinate of center
   * @param y y-coordinate of center
   * @param r radius
   * @throws IllegalArgumentException if r is < 0
   */
  public Circle(int x, int y, int r) {
    if (r < 0)
      throw new IllegalArgumentException("Radius cannot be < 0.");
    
    // While constructing a new Circle, move the location of upper left corner
    // from default (0, 0) to (x - r, y - r), which is the new location of
    // bounding box's upper left corner of the Circle should be.
    super.moveTo(x - r, y - r);
    centerX = x;
    centerY = y;
    radius = r;
    height = 2 * r; // Change the height from default value 10 to 2 * r.
  }

  /**
   * Returns true if the point (x, y) is on the Circle.
   * @param x x-coordinate of the point
   * @param y y-coordinate of the point
   * @return true if the point (x, y) is on the Circle
   */
  public boolean isOn(int x, int y) {
    // Determine by using the distance formula.
    return Math.sqrt(Math.pow(x - centerX, 2) + Math.pow(y - centerY, 2)) <= radius;
  }
  
  /**
   * Moves the Circle from initial center to the specified point.
   * @param newX the x-coordinate of new center
   * @param newY the y-coordinate of new center
   */
  public void moveTo(int newX, int newY) {
    // While moving the Circle, move the location of upper left corner as well.
    shiftBy(newX - centerX, newY - centerY);
  }
  
  /**
   * Shifts the Circle by a specified amount.
   * @param deltaX the difference between the initial x-coordinate and the new x-coordinate
   * @param deltaY the difference between the initial y-coordinate and the new y-coordinate
   */
  public void shiftBy(int deltaX, int deltaY) {
    // While shifting the Circle, shift the location of upper left corner as well.
    super.shiftBy(deltaX, deltaY);
    centerX += deltaX;
    centerY += deltaY;
  }
  
  /**
   * String representation of this Circle, including the location of center and radius.
   * @return String representation of this Circle 
   */
  public String toString() {
    return "This is a Circle centered at (" + centerX + ", " + centerY + ") with " +
           "radius " + radius + ".";
  }
  
  /**
   * Tests if constructur and methods work fine.
   * @param args
   */
  public static void main(String args[]) {
    Circle c1 = new Circle(15, 20, 10);
    System.out.println(c1);
    System.out.println(c1.isOn(15, 15));
    System.out.println(c1.isOn(5, 10));
    System.out.println("The upper left corner of the bounding box of c1 is " +
                       "(" + c1.upperLeftX + ", " + c1.upperLeftY + ").");
    c1.moveTo(10, 10);
    System.out.println(c1);
    System.out.println(c1.isOn(15, 15));
    System.out.println(c1.isOn(5, 10));
    System.out.println("The upper left corner of the bounding box of c1 is " +
                       "(" + c1.upperLeftX + ", " + c1.upperLeftY + ").");
    
    Circle c2 = new Circle(40, 20, 5);
    System.out.println(c2);
    System.out.println(c2.isOn(43, 23));
    System.out.println(c2.isOn(36, 27));
    System.out.println("The upper left corner of the bounding box of c2 is " +
                       "(" + c2.upperLeftX + ", " + c2.upperLeftY + ").");
    c2.shiftBy(-5, 5);
    System.out.println(c2);
    System.out.println(c2.isOn(43, 23));
    System.out.println(c2.isOn(36, 27));
    System.out.println("The upper left corner of the bounding box of c2 is " +
                       "(" + c2.upperLeftX + ", " + c2.upperLeftY + ").");
  }
}