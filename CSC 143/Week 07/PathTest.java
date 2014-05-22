import junit.framework.*;

/** 
 * Unit tests for Path.
 * @author Chun-Wei Chen
 * @version 02/27/12
 */
public class PathTest extends TestCase
{
  private Path testPath; // a Path
  
  /**
   * Initializes instance variable.
   */
  public void setUp() {
    testPath = new Path(0.0, 0.0);
    testPath.appendLocation(120.5, 23.5);
    testPath.appendLocation(180.0, -90.0);
  }
  
  /**
   * Tests the constructor in Path class.
   */
  public void testConstructor() {
    Path path1 = new Path(78.9, -4.32);
    assertEquals(1, path1.locations());
    try {
      Path path2 = new Path(180.1, -32.8);
      fail("Should have thrown IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      
    }
    try {
      Path path3 = new Path(6.67, 90.2);
      fail("Should have thrown IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      
    }
  }
  
  /**
   * Tests the deep copy constructor in the Path class.
   */
  public void testConstructor2() {
    Path copyPath = new Path(testPath);
    assertTrue(copyPath.equals(testPath));
    testPath.appendLocation(15.29, 35.7);
    assertFalse(copyPath.equals(testPath));
    try {
      Path badPath = new Path(null);
      fail("Should have thrown IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      
    }
  }
  
  /**
   * Tests the locations method in the Path class.
   */
  public void testLocations() {
    assertEquals(3, testPath.locations());
  }
  
  /**
   * Tests the appendLocation method in the Path class.
   */
  public void testAppendLocation() {
    assertFalse(testPath.appendLocation(180.0, -90.0));
    assertEquals(3, testPath.locations());
    assertEquals("{0.0" + ((char)176) + "E, 0.0" + ((char)176) + "N -> 120.5" + 
                 ((char)176) + "E, 23.5" + ((char)176) + "N -> 180.0" + 
                 ((char)176) + "E, 90.0" + ((char)176) + "S}", testPath.toString());
    assertTrue(testPath.appendLocation(-103.6, 4.55));
    assertEquals(4, testPath.locations());
    assertEquals("{0.0" + ((char)176) + "E, 0.0" + ((char)176) + "N -> 120.5" + 
                 ((char)176) + "E, 23.5" + ((char)176) + "N -> 180.0" + 
                 ((char)176) + "E, 90.0" + ((char)176) + "S -> 103.6" + 
                 ((char)176) + "W, 4.55" + ((char)176) + "N}", testPath.toString());
    try {
      assertTrue(testPath.appendLocation(45.5, -103.6));
      fail("Should have thrown IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      
    }
  }
  
  /**
   * Tests the insertLocation method in the Path class.
   */
  public void testInsertLocation() {
    assertTrue(testPath.insertLocation(130.45, 52.7));
    assertEquals(4, testPath.locations());
    assertEquals("{0.0" + ((char)176) + "E, 0.0" + ((char)176) + "N -> 130.45" + 
                 ((char)176) + "E, 52.7" + ((char)176) + "N -> 120.5" + ((char)176) + 
                 "E, 23.5" + ((char)176) + "N -> 180.0" + ((char)176) + "E, 90.0" + 
                 ((char)176) + "S}", testPath.toString());
    assertFalse(testPath.insertLocation(0.0, 0.0));
    
    Path path = new Path(10.0, 0.0);
    path.insertLocation(10.0, 10.0);
    path.insertLocation(10.0, 20.0);
    path.insertLocation(10.0, 30.0);
    path.insertLocation(10.0, 15.0);
    path.insertLocation(10.0, 25.0);
    assertEquals(6, path.locations());
    assertEquals("{10.0" + ((char)176) + "E, 0.0" + ((char)176) + "N -> 10.0"
                 + ((char)176) + "E, 10.0" + ((char)176) + "N -> 10.0" + ((char)176) +
                 "E, 15.0" + ((char)176) + "N -> 10.0" + ((char)176) + "E, 20.0" + 
                 ((char)176) + "N -> 10.0" + ((char)176) + "E, 25.0" + ((char)176) + 
                 "N -> 10.0"  + ((char)176) + "E, 30.0" + ((char)176) + "N}", 
                 path.toString());
    try {
      testPath.insertLocation(130.45, 92.7);
      fail("Should have thrown IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      
    }
  }
  
  /**
   * Tests the deleteLocation method in the Path class.
   */
  public void testDeleteLocation() {
    assertFalse(testPath.deleteLocation(179.9, -90.0));
    assertEquals(3, testPath.locations());
    assertFalse(testPath.deleteLocation(36.7, -92.5));
    assertEquals(3, testPath.locations());
    assertTrue(testPath.deleteLocation(0.0, 0.0));
    assertEquals(2, testPath.locations());
    assertTrue(testPath.deleteLocation(180.0, -90.0));
    assertEquals(1, testPath.locations());
    assertFalse(testPath.deleteLocation(120.5, 23.5));
    assertEquals(1, testPath.locations());
    
    Path path = new Path(10.0, 10.0);
    path.appendLocation(20.0, 10.0);
    path.appendLocation(10.0, 10.0);
    assertTrue(path.deleteLocation(20.0, 10.0));
    assertEquals(1, path.locations());
  }
  
  /**
   * Tests the totalPathLength method in the path class.
   */
  public void testTotalPathLength() {
    Path path = new Path(-25.0, 39.7);
    assertEquals(0.0, path.totalPathLength());
    assertEquals(8834.637, Math.round(1000 * testPath.totalPathLength()) / 1000.0);
  }
  
  /**
   * Tests the equals method in the path class. 
   */
  public void testEquals() {
    String s = "Not Equal";
    assertFalse(testPath.equals(s));
    
    Path path1 = null;
    assertFalse(testPath.equals(path1));
    
    Path path2 = new Path(-123.45, 87.65);
    assertFalse(testPath.equals(path2));
    
    Path path3 = new Path(0.0, 0.0);
    path3.appendLocation(120.5, 23.5);
    path3.appendLocation(179.9, -90.0);
    assertFalse(testPath.equals(path3));
    path3.deleteLocation(179.9, -90.0);
    path3.appendLocation(180.0, -90.0);
    assertTrue(testPath.equals(path3));
    assertTrue(testPath.equals(testPath));
  }
  
  /**
   * Tests the distanceToClosestStop method in the Path class.
   */
  public void testDistanceToClosestStop() {
    assertEquals(1842.252, 
                 Math.round(1000 * testPath.distanceToClosestStop(70.0, 10.0)) / 1000.0);
    assertEquals(1952.103, 
                 Math.round(1000 * testPath.distanceToClosestStop(155.0, -40.0)) / 1000.0);
    try {
      testPath.distanceToClosestStop(180.5, 55.2);
      fail("Should have thrown IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      
    }
  }
 /**
  * Tests the createReversePath method in the Path class.
  */
  public void testCreateReversePath() {
    Path path = testPath.createReversePath();
    assertEquals(3, path.locations());
    assertEquals("{180.0" + ((char)176) + "E, 90.0" + ((char)176) + "S -> 120.5" + 
                 ((char)176) + "E, 23.5" + ((char)176) + "N -> 0.0" + ((char)176) +
                 "E, 0.0" + ((char)176) + "N}", path.toString());
  }
  
  /**
   * Tests the toString method in the Path class.
   */
  public void testToString() {
    assertEquals("{0.0" + ((char)176) + "E, 0.0" + ((char)176) + "N -> 120.5" + 
                 ((char)176) + "E, 23.5" + ((char)176) + "N -> 180.0" + ((char)176) +
                 "E, 90.0" + ((char)176) + "S}", testPath.toString());
  }
}