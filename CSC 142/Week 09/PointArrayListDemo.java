import java.util.*;

/**
 * This class demonstrates the syntax for working with an ArrayList
 * of objects of a particular type.  
 * 
 * @author CSC 142 
 * @version 11-23-10
 */
public class PointArrayListDemo
{
    private ArrayList<Point> pointList;
    
    /**
     * Construct a new demo and fill the collection with a few Points
     */
    public PointArrayListDemo( ) {
        pointList = new ArrayList<Point>( );  // construct the ArrayList
        
        // get some items into the collection by some means...
        // we will do this by simply creating a few Points directly
        
        pointList.add( new Point( 20, 30 ) );
        pointList.add( new Point( -5, 50 ) );
        pointList.add( new Point( 5, 10 ) );
        pointList.add( new Point( 8, 77 ) );
    }
    
    /**
     * @return the average value of the x coordinates
     */
    public double getAverageX( ) {
        double sum = 0;  // initialize accumulator
        Iterator<Point> it = pointList.iterator( );  // standard iteration pattern
        while ( it.hasNext( ) ) {
            Point p = it.next( ); // Notice that next( ) returns type Point
            sum = sum + p.getX( );
        }
        return sum / pointList.size( );
    }
    
    /**
     * @return a list (ArrayList) of all points with a  
     * distance from the origin not more than than maxDist
     */
    public ArrayList<Point> getNearPoints( double maxDist ) {
        ArrayList<Point> nearPoints = new ArrayList<Point>( );  // list for results
        Iterator<Point> it = pointList.iterator( );
        while ( it.hasNext( ) ) {
            Point p = it.next( );
            double d = Math.sqrt( Math.pow( p.getX( ), 2 ) 
                                  + Math.pow( p.getY( ), 2 ) );
            if ( d <= maxDist )
                nearPoints.add( p );
        }
        return nearPoints;
    }    
    
    // Run some tests...
    public static void main( String[] args ) {
      PointArrayListDemo demo = new PointArrayListDemo();
      System.out.println( "The average of the x-coordinates is: " 
                           + demo.getAverageX() );
      System.out.println( "Points within 100 units of the origin: "
                           + demo.getNearPoints(100) );
      System.out.println( "Points within 50 units of the origin: "
                           + demo.getNearPoints(50) );
      System.out.println( "Points within 20 units of the origin: "
                           + demo.getNearPoints(20) );
      System.out.println( "Points within 10 units of the origin: "
                           + demo.getNearPoints(10) );
    }
}
