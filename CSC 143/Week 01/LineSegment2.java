/**
 * Represent a line-segment in a 2-dimensional coordinate plane by keeping track 
 * of its endpoints.
 * In order for clarity on which point a client specifies, we refer to a first point
 * and a 2nd point.  The first point is the 1st parameter to the constructor.
 * 
 * This variation of the LineSegment class is enhanced with if statements in 
 * several places and also demonstrates throwing exceptions.  Finally, a toString
 * method has been added.
 * 
 * @author csc142
 * @version W12  
 */
public class LineSegment2
{
     private Point p1, p2;

    /**
     * Create a LineSegment2 defined by these 2 endpoints.  
     * p1 and p2 must be non-null.
     * @param p1 the first point
     * @param p2 the second point
     * @throws IllegalArgumentException if either  parameter is null
     */
    public LineSegment2(Point p1, Point p2)
    {
        if ( p1 == null || p2 == null )
            throw new IllegalArgumentException( "Null argument not allowed." );
        this.p1 = p1;
        this.p2 = p2;
    }
    
    /**
     * Replace the current first point with the parameter,
     * which must be non-null.
     * @param p the new first point
     * @throws IllegalArgumentException if the parameter is null
     */
    public void setFirstPoint(Point p)
    {
        if ( p == null )
            throw new IllegalArgumentException( "Null argument not allowed." );
        this.p1 = p;
    }
    
     /**
     * Replace the current second point with the parameter,
     * which must be non-null.
     * @param p the new second point
     * @throws IllegalArgumentException if the parameter is null
     */
    public void setSecondPoint(Point p)
    {
        if ( p == null )
            throw new IllegalArgumentException( "Null argument not allowed." );
        this.p2 = p;
    }
    
    /**
     * Retrieve the first point of this LineSegment2.
     * @return the first point 
     */
    public Point getFirstPoint()
    {
        return p1;
    }
    
     /**
     * Retrieve the second point of this LineSegment2.
     * @return the second point 
     */
    public Point getSecondPoint()
    {
        return p2;
    }
    
    /**
     * Calculate the slope of this LineSegment2.  
     * To prevent an ArithmeticException, the special case of a vertical 
     * LineSegment2 is tested separately, with an appropriate result returned.
     * 
     * @return the slope
     */
    public double slope( )
    {
        double dx, dy;
        dx = this.p1.getX( ) - this.p2.getX( );
        
        if ( dx == 0 )
            return Double.POSITIVE_INFINITY;
            
        // Notice how the if statement above provides an EARLY EXIT from
        // the method.  The remainder of the code is never executed when
        // dx == 0.  This is very compact and convenient, but it is 
        // sometimes viewed as poor design practice.  The slope2() method
        // below shows an alternave solution.  You should be familiar
        // with both approaches.
        
        dy = this.p1.getY( ) - this.p2.getY( );
        return dy / dx;
    }
    
    /**
     * Calculate the slope of this LineSegment2.  
     * To prevent an ArithmeticException, the special case of a vertical 
     * LineSegment2 is tested separately, with an appropriate result returned.
     * 
     * @return the slope
     */
    public double slope2( )
    {
        double dx, dy, answer;
        dx = this.p1.getX( ) - this.p2.getX( );
        
        if ( dx == 0 )
            answer = Double.POSITIVE_INFINITY;
        else {
            dy = this.p1.getY( ) - this.p2.getY( );
            answer = dy / dx;
        }
        // Notice how this version of the 'slope' method has just one
        // return statement as the last line of the method.  This may  
        // be a better approach in some situations.  Be sure you are 
        // familiar with both this approach and the one in the 'slope'
        // method that appears just before this method.
        
        return answer;
    }
    
    /**
     * Calculates the distance between the given Point and the midpoint of this
     * LineSegment2.
     * @param p the point to calculate the distance to
     * @return the distance
     */
    public double distance(Point p) 
    {
        Point middle = this.midpoint();  
        return p.distance(middle);
    }
    
    /**
     * Finds the midpoint of this LineSegment2.
     * @return the midpoint Point
     */
    public Point midpoint()
    {
        Point temp = p1.midPoint(p2);
        return temp;
    }
    
    /**
     * Creates a new LineSegment2 that has as its endpoints the midpoint of this
     * LineSegment2 and the other LineSegment2.
     * @param other the 2nd LineSegment2
     * @return a new LineSegment2
     */
    public LineSegment2 connectMids(LineSegment2 other)
    {
        Point mid1 = this.midpoint();
        Point mid2 = other.midpoint();
        LineSegment2 result = new LineSegment2(mid1, mid2);
        return result;
    } 
    
    /**
     * A String representation of this LineSegment object.
     * @return the String representation
     */
    public String toString() {
        return "LineSegment2 extending from " + p1.toString() + " to " + p2.toString();
    }
    
    /**
     * Perform a few simple tests of the LineSegment2 class.
     */
    public static void main(String[] args) {
        Point a = new Point(3, 4);
        Point b = new Point(-4, 1);
        LineSegment2 line1 = new LineSegment2(a, b);
        LineSegment2 line2 = new LineSegment2(new Point(), new Point(5, -5));
        System.out.println("The first line is \n    " + line1.toString());
        System.out.println("The first line is \n    " + line2.toString());
        System.out.println("The midpoint of the second line is at " + line2.midpoint().toString());
        System.out.println("The slope of the first line is " + line1.slope());
        System.out.printf("The slope of the first line is %.3f\n", line1.slope()); // notice the \n for a new line
        
        // change the first line
        line1.setFirstPoint(new Point(-4, 5));
        System.out.println("\nThe first line has been changed to \n    " + line1.toString());
        System.out.println("The slope of the first line is " + line1.slope());
        System.out.printf("The slope of the first line is %.3f\n", line1.slope()); // notice the \n for a new line
        
        System.out.println("\nA line connecting the midpoints of line1 and line2 is \n    " 
                           + line1.connectMids(line2).toString());
        
        // add your own test code here to experiment with Point and LineSegment objects
    }
}
