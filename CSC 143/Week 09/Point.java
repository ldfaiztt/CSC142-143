
/**
 * A simple class to hold a coordinate pair.
 * Updated to include 'equals' and 'compareTo'.
 * 
 * @author CSC 142
 * @version 5/29/08
 */
public class Point implements Comparable<Point>
{
    // the x coordinate of the point 
    private double x;
    // the y coordinate of the point 
    private double y;

    // Constructors - called to create new Point objects.

    /** 
     * Constructs a new Point object with the specified coordinates.
     * @param xCoord the new value for the x coordinate of the point
     * @param yCoord the new value for the y coordinate of the point
     */
    public Point( double xCoord, double yCoord ) {
        x = xCoord;
        y = yCoord;
    }

    /**
     * Constructs a new Point object with the coordinates (0,0). 
     */
    public Point( ) { 
        x = 0;
        y = 0;
    }

    // Here is a set of simple update (mutator) methods 
    // (methods that modify state).
    
    /**
     * Assign a value to the x coordinate of the point.
     * @param newX the new value for the x coordinate of the point
     */
    public void setX( double newX ) {
        x = newX;
    }
    
    /**
     * Assign a value to the y coordinate of the point.
     * @param newY the new value for the y coordinate of the point
     */
    public void setY( double newY ) {
        y = newY;
    }
    
    /**
     * Assign values to both coordinates of the point.
     * @param newX the new value for the x coordinate of the point
     * @param newY the new value for the y coordinate of the point
     */
    public void setPoint( double newX, double newY ) {
        x = newX;
        y = newY;
    }

    // Here is a set of simple accessor methods 
    // (query methods that report state).
    
    /** 
     * Get the value of the x coordinate of the point.
     * @return the x coordinate of the point
     */
    public double getX( ) {
        return x;
    }
    
    /** 
     * Get the value of the y coordinate of the point.
     * @return the y coordinate of the point
     */
    public double getY( ) {
        return y;
    }
    
    // Here are a few other query methods.
    
    /**
     * Calculate the distance between this point and the origin.
     * @return the distance to (0, 0)
     */
    public double distanceToOrigin( ) {
        return Math.sqrt( x * x + y * y );
    }
  
    /** Calculate the distance between this point and some other point.
     * @param p the other point
     * @return the distance between the 2 points
     */
    public double distance( Point p ) {
        double diffX = x - p.x;
        double diffY = y - p.y;
        return  Math.sqrt( diffX * diffX + diffY * diffY );
    }
  
    /**
     * Find the midpoint between this point and another point.
     * @param p the other point
     * @return a Point object located midway between the two points
     */
    public Point midPoint( Point p ) {
        double midX = ( x + p.x ) / 2;
        double midY = ( y + p.y ) / 2;
        return new Point( midX, midY );
    }
  
    /**
     * A String representation of this Point object.
     * @return the String representation
     */
    public String toString( ) {
        return "(" + x + ", " + y + ")";
    }
    
    ////////////// needed for Comparable<Point> ///////////////
    
    /**
     * Order Point objects based on y coordinate value.
     */
    public int compareTo( Point p ) {
      if ( y == p.y ) 
        return 0;
      if ( y > p.y ) 
        return 1;
      else
        return -1;
    }
    
    /**
     * Should be consistent with compareTo.
     */
    public boolean equals( Object o ) {
      if ( !(o instanceof Point) ) 
        return false;
      Point p = (Point)o;
      return y == p.y;
    }
    
    // Simple method to test placing points in a PriorityQueue.
    public static void test( ) {
      java.util.PriorityQueue<Point> q = new java.util.PriorityQueue<Point>( );
      // Notice the x coordinate marks the order in which Points are added.
      q.add( new Point( 1, 6 ) );
      q.add( new Point( 2, 3 ) );
      q.add( new Point( 3, 12 ) );
      q.add( new Point( 4, 8 ) );
      q.add( new Point( 5, 3 ) );
      q.add( new Point( 6, 2 ) );
      q.add( new Point( 7, 18 ) );
      q.add( new Point( 8, 9 ) );
      q.add( new Point( 9, 9 ) );
      q.add( new Point( 10, 9 ) );
      q.add( new Point( 11, 9 ) );
      q.add( new Point( 12, 9 ) );
      q.add( new Point( 13, 9 ) );
      q.add( new Point( 14, 9 ) );
      for ( int i = 0; i < 15; i++ )
        System.out.println( q.poll() );
    }
    
    public static void main(String[] args) {
      test();
    }
}