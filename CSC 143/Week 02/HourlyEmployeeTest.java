import junit.framework.TestCase;

/**
 * Example of a JUnit test class for HourlyEmployee
 * (Similar tests should be constructed for the other classes.)
 * 
 * @author Hal Perkins
 * @version CSE143 lecture example, Sp04; mod 1/9/05, vo 
 */
public class HourlyEmployeeTest extends TestCase {
  
  // instance variable for test
  private HourlyEmployee e;
  
  /** set up instance variables for each test */
  protected void setUp() {
    e = new HourlyEmployee("smith", 17, 20.00);
  }
  
  /** test name access method for newly constructed HourlyEmployee */
  public void testGetName() {
    assertEquals("name", "smith", e.getName());
  }
  
  /** test id access method for newly constructed HourlyEmployee */
  public void testGetId() {
    assertEquals("ID", 17, e.getId());
  }
  
  /** test add/reset hours and regular pay calculation */
  public void testRegularHours() {
    e.addHours(20);
    assertEquals("20 hours pay", 400.00, e.getPay(), 0.0);
    e.addHours(20);
    assertEquals("40 hours pay", 800.00, e.getPay(), 0.0);
    e.resetHours();
    assertEquals("reset hours pay", 0.00, e.getPay(), 0.0);
  }
  
  /** test overtime pay calculation */
  public void testOvertimeHours() {
    e.addHours(50);
    assertEquals("50 hours pay", 800.00 + 300.00, e.getPay(), 0.0);
  }
  
}