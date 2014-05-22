import junit.framework.*;
import java.util.*;

/**
 * Unit tests for SimpleArrayList.  CSE143 demonstration Au03, Sp04
 * 
 * @author CSC 143
 * @version orig UW 4/7/04; modified 2/13/04 by vo; 
 * updated 5/10/06, 2/7/07, 11/4/09, 2/9/12 by vo
 */
public class SimpleArrayListTest extends TestCase {
  
  private SimpleArrayList<String> testList;
  
  public void setUp( ) {
    testList = new SimpleArrayList<String>( );
    testList.add( "Bugs" );
    testList.add( "Elmer" );
    testList.add( "Tweety" );
  }
 
  /** test constructor and size( ) */
  public void testConstructor( ) {
    SimpleArrayList<String> a = new SimpleArrayList<String>( );
    SimpleArrayList<String> b = new SimpleArrayList<String>( 12 );
    assertEquals( 0, a.size( ) );
    assertEquals( 0, b.size( ) );
  }
  
  /** test add */
  public void testAdd( ) {
    SimpleArrayList<String> a = new SimpleArrayList<String>( );
    a.add( "something" );
    assertEquals( 1, a.size( ) );
    // make sure it also works when list is not empty
    a.add( "something else" );  
    assertEquals( 2, a.size( ) );
  }
  
  /** test dynamic expansion */
  public void testExpand( ) {
    SimpleArrayList<String> a = new SimpleArrayList<String>( );
    for ( int i = 0; i <= 100; i++ ) {
      a.add( "item" + i );
    }
    assertEquals( 101, a.size( ) );
    // check first, middle, last
    assertEquals( "item0",    a.get( 0 ) );
    assertEquals( "item100", a.get( 100 ) );
    assertEquals( "item32",  a.get( 32 ) );
  }
  
  /** test get */
  public void testGet( ) {
    // test normal access
    assertEquals( "Bugs", testList.get( 0 ) );    
    assertEquals( "Elmer", testList.get( 1 ) );    
    assertEquals( "Tweety", testList.get( 2 ) );
    assertEquals( 3, testList.size( ) );
    
    // verify out of bounds access throws an exception
    try {
      String s = testList.get( 3 );
      fail( "Should have thrown IndexOutOfBoundsException" );
    } catch ( IndexOutOfBoundsException e ) {
      // success
    }
    try {
      String s = testList.get( -1 );
      fail( "Should have thrown IndexOutOfBoundsException" );
    } catch ( IndexOutOfBoundsException e ) {
      // success
    } 
  }
  
  /** test set */
  public void testSet( ) {
    // normal access
    String result = testList.set( 1, "pqr" );
    assertEquals( "Elmer", result);
    assertEquals( "Bugs", testList.get( 0 ) );    
    assertEquals( "pqr", testList.get( 1 ) );    
    assertEquals( "Tweety", testList.get( 2 ) );
    assertEquals( 3, testList.size( ) );
    result = testList.set( 0, "abc" );
    assertEquals( "Bugs", result );
    assertEquals( "abc", testList.get( 0 ) );    
    assertEquals( "pqr", testList.get( 1 ) );    
    assertEquals( "Tweety", testList.get( 2 ) );
    assertEquals( 3, testList.size( ) );
    result = testList.set( 2, "xyz" );
    assertEquals( "Tweety", result );
    assertEquals( "abc", testList.get( 0 ) );    
    assertEquals( "pqr", testList.get( 1 ) );    
    assertEquals( "xyz", testList.get( 2 ) );
    assertEquals( 3, testList.size( ) );
    
    // check that out of bounds access throws an exception
    try {
      String s = testList.set( 3, "something" );
      fail( "Should have thrown IndexOutOfBoundsException" );
    } catch ( IndexOutOfBoundsException e ) {
      // success
    }
    try {
      String s = testList.set( -1, "something else" );
      fail( "Should have thrown IndexOutOfBoundsException" );
    } catch ( IndexOutOfBoundsException e ) {
      // success
    }
  }
  
  /** test isEmpty */
  public void testIsEmpty( ) {
    SimpleArrayList<String> a = new SimpleArrayList<String>( );
    assertTrue( a.isEmpty( ) );
    a.add( "stuff" );
    assertFalse( a.isEmpty( ) );
  }
  
  /** test clear and isEmpty */
  public void testClear( ) {
    assertFalse( testList.isEmpty( ) );
    testList.clear( );
    assertTrue( testList.isEmpty( ) );
  }
  
  /** test indexOf */
  public void testIndexOf( ) {
    assertEquals( 0, testList.indexOf( "Bugs" ) );
    assertEquals( 1, testList.indexOf( "Elmer" ) );
    assertEquals( 2, testList.indexOf( "Tweety" ) );
    assertEquals( -1, testList.indexOf( "Bunny" ) );
  }
  
  /** test contains */
  public void testContains( ) {
    assertTrue( testList.contains( "Bugs") );
    assertFalse( testList.contains( "Bunny") );
  }
  
  /** test remove(pos) */
  public void testRemoveEnds( ) {
    String result = testList.remove( 0 );
    assertEquals( "Bugs", result );
    assertEquals( 2, testList.size( ) );
    assertEquals( "Elmer", testList.get( 0 ) );
    assertEquals( "Tweety", testList.get( 1 ) );
    result = testList.remove( 1 );
    assertEquals( "Tweety", result );
    assertEquals( 1, testList.size( ) );
    assertEquals( "Elmer", testList.get( 0 ) );
    testList.remove( 0 );
    assertTrue( testList.isEmpty( ) );
  }
  
  public void testRemoveMiddle( ) {
    String result = testList.remove( 1 );
    assertEquals( "Elmer", result );
    assertEquals( 2, testList.size( ) );
    assertEquals( "Bugs", testList.get( 0 ) );
    assertEquals( "Tweety", testList.get( 1 ) );
    
    // check that out of bounds access throws an exception
    try {
      String s = testList.remove( 2 );
      fail( "Should have thrown IndexOutOfBoundsException" );
    } catch ( IndexOutOfBoundsException e ) {
      // success
    }
    try {
      String s = testList.remove( -1 );
      fail( "Should have thrown IndexOutOfBoundsException" );
    } catch ( IndexOutOfBoundsException e ) {
      // success
    }
  }
   
  /** test remove( obj ) */
  public void testRemoveObj( ) {
    assertFalse( testList.remove("Wabbit" ) );
    assertTrue( testList.remove("Bugs" ) );
    assertEquals( 2, testList.size( ) );
    assertEquals( "Elmer", testList.get( 0 ) );
    assertEquals( "Tweety", testList.get( 1 ) );
  }
   
  /** test add( pos ) */
  public void testAddPos( ) {
    testList.add( 1, "Wabbit" );
    assertEquals( 4, testList.size( ) );
    assertEquals( "Bugs", testList.get( 0 ) );
    assertEquals( "Wabbit", testList.get( 1 ) );
    assertEquals( "Elmer", testList.get( 2 ) );
    assertEquals( "Tweety", testList.get( 3 ) );
        
    testList.add( 0, "Moose" );
    assertEquals( 5, testList.size( ) );
    assertEquals( "Moose", testList.get( 0 ) );
    assertEquals( "Bugs", testList.get( 1 ) );
    assertEquals( "Wabbit", testList.get( 2 ) );
    assertEquals( "Elmer", testList.get( 3 ) );
    assertEquals( "Tweety", testList.get( 4 ) );
    
    testList.add( 5, "Squirrel" );
    assertEquals( 6, testList.size( ) );
    assertEquals( "Moose", testList.get( 0 ) );
    assertEquals( "Bugs", testList.get( 1 ) );
    assertEquals( "Wabbit", testList.get( 2 ) );
    assertEquals( "Elmer", testList.get( 3 ) );
    assertEquals( "Tweety", testList.get( 4 ) );
    assertEquals( "Squirrel", testList.get( 5 ) );
  }
  
  /** test equals( object ) */
  public void testEquals( ) {
    // test equality on SimpleArrayLists
    SimpleArrayList<String> a = new SimpleArrayList<String>( );
    SimpleArrayList<String> b = new SimpleArrayList<String>( );
    assertTrue( a.equals( b ) );
    assertTrue( b.equals( a ) );
    a.add( "something" );
    assertFalse( a.equals( b ) );
    assertFalse( b.equals( a ) );
    b.add( "something" );
    assertTrue( a.equals( b ) );
    assertTrue( b.equals( a ) );
    
    // test equality with other kinds of objects
    assertFalse( a.equals( null ) );
    assertFalse( a.equals( new HashMap( ) ) );
  }
  
  /** test a list with a null item */
  public void testNull( ) {
    String result = testList.set( 1, null );
    assertEquals( "Elmer", result);
    assertEquals( "Bugs", testList.get( 0 ) );    
    assertEquals( null, testList.get( 1 ) );    
    assertEquals( "Tweety", testList.get( 2 ) );
    assertEquals( 3, testList.size( ) );
    assertEquals( 0, testList.indexOf( "Bugs" ) );
    assertEquals( 1, testList.indexOf( null ) );
    assertEquals( 2, testList.indexOf( "Tweety" ) );
    SimpleArrayList<String>test2 = new SimpleArrayList<String>( );
    test2.add( "Bugs" );
    test2.add( "Elmer" );
    test2.add( "Tweety" );
    assertFalse( testList.equals( test2 ) );
    assertFalse( test2.equals( testList ) );
    test2.set( 1, null );
    assertTrue( testList.equals( test2 ) );
    assertTrue( test2.equals( testList ) );
  }  
  
  public void testIterator( ) {
    Iterator<String> it = testList.iterator( );
    assertTrue( it.hasNext( ) );
    assertEquals( "Bugs", it.next( ) );
    assertTrue( it.hasNext( ) );
    assertEquals( "Elmer", it.next( ) );
    assertTrue( it.hasNext( ) );
    assertEquals( "Tweety", it.next( ) );
    assertFalse( it.hasNext( ) );
    try {
      String s = it.next( );
      fail( "should have thrown a NoSuchElementException exception" );
    } catch ( NoSuchElementException e ) {
      // success
    }
    // add code to test the 'remove' method
    it = testList.iterator( );
    try {
      it.remove( ); // can't call 'remove' before calling 'next'
      fail( "should have thrown an IllegalStateException exception" );
    } catch ( IllegalStateException e ) {
      // success
    }    
    it.next(); // "Bugs"
    it.remove(); // test removing first element -- should remove "Bugs"
    // verify that the list has been updated properly
    assertEquals( 2, testList.size( ) );
    assertEquals( -1, testList.indexOf( "Bugs" ) );
    assertEquals( 0, testList.indexOf( "Elmer" ) );
    assertEquals( 1, testList.indexOf( "Tweety" ) );
    // step to the last element
    assertTrue( it.hasNext( ) );
    assertEquals( "Elmer", it.next( ) );
    assertTrue( it.hasNext( ) );
    assertEquals( "Tweety", it.next( ) );
    it.remove(); // test removing last element -- should remove "Tweety"
    // verify that the list has been updated properly
    assertEquals( 1, testList.size( ) );
    assertEquals( -1, testList.indexOf( "Tweety" ) );
    assertEquals( 0, testList.indexOf( "Elmer" ) );
  }
  
}