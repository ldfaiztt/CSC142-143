
/**
 * A class that illustrates the use of Point and LineSegment objects.
 * This class is a "client" of classes Point and LineSegment -- it 
 * makes use of Point and LineSegment objects.
 * 
 * @author csc142 
 * @version Fall, 2006
 */
public class LineSegmentPractice
{
    // prevent the construction of LineSegmentPractice objects.
    private LineSegmentPractice( ) { }
    
    public static void test( ) 
    {
        // the LineSegment constructor requires that 2 Point object
        // be provided as arguments (actual parameters)
        Point p1 = new Point( -3, -4 );
        Point p2 = new Point( ); // a Point at (0,0)
        LineSegment s1 = new LineSegment( p1, p2 );
        
        // the same thing can be accomplished without the extra variables:
        LineSegment s2 = new LineSegment( new Point( 2, 3 ), new Point( 5, 6 ) );
        
        // the getFirstPoint method returns a Point object
        Point pFirst = s1.getFirstPoint( );
        System.out.println( "The x component of the first point of s1 is " 
                            + pFirst.getX( ) );
        
        // the same thing can be accomplished without the extra variable:
        System.out.println( "The x component of the first point of s1 is " 
                            + s1.getFirstPoint( ).getX( ) );
        System.out.println( "The x component of the second point of s1 is " 
                            + s1.getSecondPoint( ).getX( ) );
        System.out.println( "The x component of the first point of s2 is " 
                            + s2.getFirstPoint( ).getX( ) );
        System.out.println( "The x component of the second point of s2 is " 
                            + s2.getSecondPoint( ).getX( ) );
        
        // the location of the first Point can be changed by
        // providing a new Point object to replace the original one:
        Point newFirstPoint = new Point( 4, -7 );
        s1.setFirstPoint( newFirstPoint );
        System.out.println( "The x component of the new first point of s1 is " 
                            + s1.getFirstPoint( ).getX( ) );
                            
        // the same thing can be accomplished without the extra variable:
        s2.setFirstPoint( new Point( 12, 13 ) );
        System.out.println( "The x component of the new first point of s2 is " 
                            + s2.getFirstPoint( ).getX( ) );
        
        // feel free to use additional local variables, or not, as you prefer
        // in a given situation -- the main goal is to make the code easy to read
        
        // the distance method requires a Point parameter:
        System.out.println( "The distance from the midpoint of s1 to (10,10) is " 
                            + s1.distance( new Point( 10, 10 ) ) );
                            
        // the midpoint method returns a Point object:
        System.out.println( "The midpoint of s2 is " 
                            + s2.midpoint( ).toString( ) );
        
        // the connectMids method returns a LineSegment object:
        System.out.println( "A line connecting the midpoints of s1 and s2 "
                            + "has its own midpoint at " 
                            + s1.connectMids( s2 ).midpoint( ).toString( ) );
        
        
        // ADD YOUR OWN test statements here to practice working with Points:
        
    }
}
