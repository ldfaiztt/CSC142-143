import java.util.*;

/**
 * Comparator for Point objects.  Orders points according to 
 * distance from the origin, more distant points first.
 * 
 * @author CSC 143
 * @version W'12
 */
public class FarPoints implements Comparator<Point> {
  /*
   * Returns -1 if p1 is further from the origin than p2.
   * Returns +1 if p2 is further from the origin than p1.
   * Returns 0 if p1 and p2 are the same distance from the origin.
   */
  public int compare(Point p1, Point p2) {
    double d1 = p1.distanceToOrigin();
    double d2 = p2.distanceToOrigin();
    if (d1 == d2)
      return 0;
    else if (d2 > d1)
      return 1;
    else
      return -1;
  }
  
  /**
   * Test sorting an array of Points in different ways.
   */
  public static void main(String[] args) {
    Point[] points = {new Point(3, 4), new Point(4, 13), new Point(0, 0), new Point(-3, 3),
      new Point(3, 3), new Point(-5, 12), new Point(4, 3)};
    System.out.println("       Original: " + Arrays.toString(points));
    Arrays.sort(points);  // "natural" order
    System.out.println("  Natural Order: " + Arrays.toString(points));
    FarPoints comp = new FarPoints(); // construct comparator
    Arrays.sort(points, comp);  // "FarPoints" order
    System.out.println("FarPoints Order: " + Arrays.toString(points));
  }
  
  // No need to override equals()
}