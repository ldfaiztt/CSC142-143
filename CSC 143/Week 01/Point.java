
/** Represents a 2-dimensional Point
 * @author CSC 142
 * @version 2006
 */
public class Point {
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
}
