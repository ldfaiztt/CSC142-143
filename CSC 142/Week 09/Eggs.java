import java.util.*;

/**
 * Demonstrates how a method might return an empty ArrayList
 */
public class Eggs
{
  /**
   * Notice that this method ALWAYS returns an ArrayList<String>
   * object, although it may be empty (size()==0).
   */
  public static ArrayList<String> getEggs( String s ) {
    char c = s.toUpperCase().charAt(0);
    int n = (c - 'A') % 13; // this is how many eggs you get
    
    // make the carton
    ArrayList<String> carton = new ArrayList<String>();
    
    // fill the carton (This loop may run zero times!)
    for( int i = 0; i < n; i++ )
      carton.add( "Egg #" + (i+1) );
    
    // return the carton (which may be empty)
    return carton;
  }
  
  /**
   * Testing the getEggs method.
   */
  public static void main( String[] args ) {
    ArrayList<String> myEggs = getEggs( "D" );
    System.out.println( "D: " + myEggs.toString() );
    myEggs = getEggs( "Z" );
    System.out.println( "Z: " + myEggs.toString() );
    myEggs = getEggs( "A" );
    System.out.println( "A: " + myEggs.toString() );
  }
}