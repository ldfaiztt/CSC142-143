/** binary search source code for doubles
 * CSC 142 2008
 */
public class BinarySearch
{

  /**
   * when running this method, pass in the target value to search for
   */
    public static void test(double target)
    {       
        double[] array = { .6, 1.5, 2.71, 2.88, 3.0, 4.52, 4.99, 5.21, 6.5, 6.65, 7.99, 8.37, 8.92 };
        System.out.println( bSearch( array, target, 0, array.length-1 ) );
    }  

  /**
   * Demonstrates a successful match despite representational error.
   */
    public static void test2( )
    {       
        double[] array = { .6, 1.5, 2.71, 2.88 };
        double x = ( 0.1 + 0.1 + 0.1 ) * 2;
        System.out.print( "The array is " );
        showArray( array );
        System.out.print( "\nThe value of x is " + x + " and matches element " );
        System.out.println( bSearch( array, x, 0, array.length-1 ) );
    }  

    /**
     * Method to search for a value using the Binary Search algorithm
     * @param data a complete full, sorted in ascending order, array
     * @param value the value to search for
     * @param lo the starting index of the search area in the array
     * @param hi the stopping index of the search area in the array
     * @return either the index of where value is found, or -1 if value is not in the array data
     */
    public static int bSearch( double[] data, double value, int lo, int hi ) {
      // a base case. If hi < lo, then we've exhausted the search. value is not in the array
      if ( hi < lo )    
        return -1;
      
      int mid = ( hi + lo ) /2; // choose the 'middle' of the remaining array to search
      if ( match( value, data[mid] ) ) // did I find the match? 
        return mid;              // This is the second base case
      
      // search the lower 'half' or else the 'upper' half of the remaining array    
      else if ( value < data[mid] )
        return bSearch( data, value, lo, mid - 1 ); // search lower half
      else
        return bSearch( data, value, mid + 1, hi ); // search upper half
    }
    
    /**
     * Type double is subject to representational error.  Therefore, testing
     * for a match with == is not reliable.  Instead, a small amount of error
     * in the match must be allowed.  Determining what amount of error is 
     * appropriate is not necessarily trivial.  This method uses an arbitrary 
     * figure of 1.0e-9 (one times 10 to the -9th power).
     */
    private static boolean match( double a, double b ) {
        return Math.abs( a - b ) < 1.0e-9;
    }
    
    /**
     * Show the array contents (simplified version)
     */
    private static void showArray( double[] arr ) {
        for ( int i = 0; i < arr.length; i++ )
            System.out.print( arr[i] + " " );
    }
 
}
