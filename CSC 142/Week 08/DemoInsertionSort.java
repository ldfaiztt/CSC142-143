/**
 * This class creates an array of Point objects
 * then uses the Insertion Sort to sort the array.
 * It sorts in ascending order by the distance
 * from each point to the origin.
 * 
 * @author CSC 142
 * @version Fall 2011
 */
public class DemoInsertionSort
{
  /**
   * Sorts an array of Point objects according to how far 
   * from the origin each Point is located.  Points closer 
   * to the origin appear first in the sorted array.
   * Uses the INSERTION SORT algorithm.
   * @param arr the array to be sorted
   */
  public static void sortPointArray( Point[] arr ) {
    if ( arr == null || arr.length < 2 )
      return; // nothing to do
    for ( int top = 1; top < arr.length; top++ ) {  // for each item after the first
      Point temp = arr[top];
      double dist = temp.distanceToOrigin();
      int pos = top;
      while( pos > 0 && arr[pos-1].distanceToOrigin() > dist ) { 
        arr[pos] = arr[pos-1]; // while the next item is greater shift it right
        pos--; // points at new hole
      }
      arr[pos] = temp; // put saved item the hole
    }
  }
  
  /* Here are two key things to note about the insertion sort code above:
   * 1. The DECISION about where to insert each item is made by comparing
   *    the distances to the origin.
   * 2. The ACTUAL OBJECT REFERENCES are moved around in the array.
   * These are key principles for sorting objects.  No matter what sorting
   * algorithm is used, be aware of the difference between the information
   * used to make the decision about ordering and the objects being ordered.
   * The two things are the same if numbers are being sorted, but they can
   * be different if objects are being sorted.
   * 
   * Another way sorting like this could be supported would be to have
   * class Point implement the Comparable interface to define the standard
   * ordering for Point objects.
   */
  
  //////////////////// TEST SECTION //////////////////////
  
  /**
   * A simple test method
   */
  public static void main(String[] args) {
    Point[] test ={ new Point(3,4), new Point(-1,1), new Point(5,12),
      new Point(-3,5), new Point(2,-2), new Point(0,0),
      new Point(4,4), new Point(2,3) };
    
    showArray( test );      // show original array
    sortPointArray( test ); // sort the array
    showArray( test );      // show the sorted array
  }
  
    /**
     * Displays the contents of an int array on the console.
     * Precondition: the array has a length of at least one.
     * @param p the array to display
     */
  private static void showArray( Point[] p ) {
    if (p.length < 1)
      throw new IllegalArgumentException();
    System.out.print( "{ " + p[0] );
    for( int i = 1; i < p.length; i++ )
      System.out.print( ", " + p[i] );
    System.out.println( "}" );
  }
    
}