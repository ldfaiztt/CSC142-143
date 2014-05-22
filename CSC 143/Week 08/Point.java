
/** Represents a 2-dimensional Point
  * Updated to implement Comparable and override 'equals'
 * @author CSC 143
 * @version W'12 v2
 */
public class Point implements Comparable<Point> {
  private double x, y;  // the coordinates

// two different constructors
  
  /**
   * Create a Point at (0, 0)
   */
  public Point() {
    x = 0;
    y = 0;
  }
  
  /**
   * Create a Point with the given coordinates
   * @param initialX the x-coordinate
   * @param initialY the y-coordinate
   */
  public Point (double initialX, double initialY) {
    x = initialX;
    y = initialY;
  }

// update (mutator) methods 
// that change the state of a Point object 

  /**
   * Set the x-coordinate of this Point
   * @param updateX the new x-coordinate
   */
  public void setX(double updateX) {
    x = updateX;
  }
  
  /**
   * Set the y-coordinate of this Point
   * @param newY the new y-coordinate
   */
  public void setY(double updateY) {
    y = updateY;
  }

  /**
   * Set the x and y coordinates of this Point
   * @param newX the new x-coordinate
   * @param newY the new y-coordinate
   */
  public void setPoint( double newX, double newY){
    x = newX;
    y = newY;
  }
  
// query (accessor) methods  
// that somehow report the state of a Point
// without changing it

  /**
   * Get the x-coordinate of this Point
   * @return the x-coordinate
   */
  public double getX() {
    return x;
  }
  
  /** 
   * Get the y-coordinate of this Point
   * @return the y-coordinate
   */
  public double getY() {
    return y;
  }

  /**
   * Calculate the distance between this Point and the origin
   * @return the distance to (0, 0)
   */
  public double distanceToOrigin() {
    return Math.sqrt(x * x + y * y);
  }
  
  
  /** Calculate the distance between this Point and some other Point
   * @param p the other Point
   * @return the distance between the 2 Points
   */
  public double distance(Point p) {
    double diffX = x - p.x;
    double diffY = y - p.y;
    return  Math.sqrt(diffX * diffX + diffY * diffY);
  }
  
  
  /**
   * Find the midpoint between this Point and another Point
   * @param p the other Point
   * @return the Point midway between the two Points
   */
  public Point midPoint(Point p) {
    double midX = (x + p.x) / 2;
    double midY = (y + p.y) / 2;
    return new Point(midX, midY);
  }
  
  /**
   * The String version of this Point
   * @return the String representation
   */
  public String toString() {
    return "(" + x + ", " + y + ")";
  }
  
  /**
   * a test method - do not change this code!
   * it should display 3 results in a terminal window
   */
  public static void test (){
      Point alpha = new Point( 5, 5 );
      Point beta = new Point( -3, 7 );
      System.out.println( "alpha is " + alpha.distanceToOrigin() + " from the origin" );
      System.out.println( "The x coordinate of beta is " + beta.getX() );
      beta.setY( 72 );
      System.out.println( "The y coordinate of beta is " + beta.getY() );
      
    }
  
// CODE ADDED to the basic Point class we used during the Week 1 review:

  // Test two double values for effective equality
  private static boolean equivalent(double a, double b) {
    final double allowedError = 1.0e-9;  // arbitrary -- not necessarily appropriate for all applications
    return Math.abs(a - b) <= allowedError;
  }
  
  /**
   * Tests for content equality.  Note that absolute equality is not required
   * because it is not the most reasonable expectation for floating-point values.
   * @return true if 'o' is a Point object with equivalent coordinates to this Point.
   */
  public boolean equals(Object o) {
    if ( !(o instanceof Point) )
      return false;
    Point p = (Point)o;
    return equivalent(p.x, this.x) && equivalent(p.y, this.y);
  }
  
  /**
   * Compare this Point to another.  Ordering is as follows: first by
   * the x-coordinate, and then, if that's a tie, by the y-coordinate.
   * @return -1 if this point comes before Point 'p'; 0 if equal; +1 if this
   * Point comes after 'p'.
   */
  public int compareTo(Point p) {
    if (equivalent(p.x, this.x)) {
      if (equivalent(p.y, this.y))
        return 0;
      else if (this.y > p.y)
        return 1;
      else 
        return -1;
    } else if (this.x > p.x)
      return 1;
    else
      return -1;
  }
}
