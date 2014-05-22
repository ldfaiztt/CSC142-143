
/**
 * This class demonstrates the syntax for working with an Array
 * of objects of a particular type.  Compare/contrast this with
 * the PointArrayListDemo to see differences in syntax.
 * 
 * @author CSC 142 
 * @version 11-23-10
 */
public class PointArrayDemo
{
    private Point[] pointArray;
    
    /**
     * Construct a new demo and fill the collection with a few Points
     */
    public PointArrayDemo( ) {
        pointArray = new Point[4];  // construct the array
        
        // Get some items into the collection by some means...
        // we will do this by simply creating a few Points directly.
        
        // Note that this array is being completely filled, but
        // partially-filled arrays with a separately-managed size
        // are also quite common.
        
        pointArray[0] = new Point( 20, 30 );
        pointArray[1] = new Point( -5, 50 );
        pointArray[2] = new Point( 5, 10 );
        pointArray[3] = new Point( 8, 77 );
    }
    
    /**
     * Return the average value of the x coordinates
     * @return the average value of the x coordinates
     */
    public double getAverageX( ) {
        double sum = 0;  // initialize accumulator
        for ( int i = 0; i < pointArray.length; i++ ) { // standard iteration pattern
            sum = sum + pointArray[i].getX( );  // pointArray[i] is type Point
        }
        return sum / pointArray.length;
    }
    
    /**
     * Move all points in the collection in the x direction
     * @param deltaX the distance to move each Point
     */
    public void moveAllPointsHorizontally( double deltaX ) {
        for ( int i = 0; i < pointArray.length; i++ ) {
            double newX = pointArray[i].getX( ) + deltaX;
            pointArray[i].setX( newX );
            // same as: pointArray[i].setY( pointArray[i].getY( ) + deltaY );
        }
    }    
    
    // Run some tests...
    public static void main( String[] args ) {
      PointArrayDemo demo = new PointArrayDemo();
      System.out.println( "The average of the x-coordinates is: " 
                           + demo.getAverageX() );
      demo.moveAllPointsHorizontally(12.0);
      System.out.println( "The average of the x-coordinates is: " 
                           + demo.getAverageX() );
    }
}
