import java.util.*;

/**
 * This is an example of a JUnit test class.  You can search for JUnit Testing on 
 * the web if you are interested in knowing more about the subject.
 * 
 * To USE this class, place this file in same folder as your project files and 
 * open it in DrJava along with the rest of your project files.  Do this AFTER
 * you have completed work on your project.  The FIRST test comes when you try to
 * COMPILE the code.  If this test code will not compile, there is a problem with
 * your class design.  Use the syntax error messages to help you find the problem.
 * Once the code compiles, click the "Test" button on the DrJava button bar.  If
 * any tests fail, use the information to track down the problems in your code.
 * 
 * This class performs only PARTIAL testing of the project.  Verifying that the 
 * project meets the specification is part of the assignment.  However, using this
 * test class will help you make sure that you have not misspelled any method names
 * or made other very basic errors.  A much more complete set of test cases will
 * be used by your instructor to test the program you submit.
 * 
 * Passing all of these tests DOES NOT guarantee that your program is complete or
 * correct.
 * 
 * @version 11/28/2011
 */
public class TestBookStoreProjectPartial  extends junit.framework.TestCase
{
  // Instance variables -- may be used in any method
  private Book hp, bjp;
  private DVD pf, thd;
  private CD snf, th, mm;
  private String hpMethodDetails;
  
  // Class constants -- may be used in any method
  private static final double hpPrice = 24.95, bjpPrice = 113.0;
  private static final int hpQty = 1000, bjpQty = 40;
  private static final int snfQty = 1, thQty = 2, mmQty = 0;
  private static final int pfQty = 12, thdQty = 4;
  private static final String hpTitle = "Harry Potter and the Chamber of Secrets", bjpTitle = "Building Java Programs";
  private static final String mmTitle = "Mellow Madness", pfTitle = "Pulp Fiction";
  private static final String qj = "Quincy Jones", qj2 = ("Quincy " + "Jones"); // ensures content equality is tested
  private static final String jt = "John Travolta", mj = "Michael Jackson", qt = "Quentin Tarantino";
  private static final String hg = "Hermione Granger", ad = "Albus Dumbledore", dm = "Draco Malfoy";
  
  /**
   * Initializes a test state used by some of the test methods.
   * State is stored in instance variables so methods can access them.
   * This method is run before each of the test methods, i.e.
   * setUp(), test001(), setUp(), test002(), setUp(), test003(), etc.
   */
  public void setUp() {
    // Create first book
    String[] jkr = {"J.K. Rowling"};
    hp = new Book(hpTitle, jkr, hpPrice);
    String[] hpChar = {hg, "Harry Potter", "Ron Weasley", 
      "Rubeus Hagrid", dm, ad};
    hp.setCharacters(hpChar);
    hp.changeQuantity(hpQty);
    
    // Create second book
    String[] rs = {"Stuart Reges", "Marty Stepp"};
    bjp = new Book(bjpTitle, rs, bjpPrice);
    // note: no characters to set
    bjp.changeQuantity(2);
    bjp.changeQuantity(bjpQty-2);

    // extract method details for class Book [not covered in CSC 142]
    java.lang.reflect.Method[] hpMethods = hp.getClass().getMethods();
    hpMethodDetails = "";
    for( int i = 0; i < hpMethods.length; i++ )
      hpMethodDetails += hpMethods[i].toString();    
    
    // Create 3 CDs
    snf = new CD("John Travolta Sings", jt, "Cary E. Mansfield", 7.95);
    snf.changeQuantity(snfQty);
    th = new CD("Thriller", mj, qj2, 12.95);
    th.changeQuantity(thQty);
    mm = new CD(mmTitle, qj, "Creed Taylor", 29.95);
    mm.changeQuantity(mmQty);
    
    // Create 2 DVDs
    pf = new DVD(pfTitle, qt, 19.99);
    String[] pfCast = {jt, "Samuel L. Jackson", "Bruce Willis"};
    pf.setCast(pfCast);
    pf.changeQuantity(pfQty);
    
    thd = new DVD("Thriller", "John Landis", 18.59);
    String[] thdCast = {mj, "Ola Ray", "Vincent Price"};
    thd.setCast(thdCast);
    thd.changeQuantity(thdQty);
}
  
  /**
   * Tests basic functionality of the getQuantity method.
   */
  public void testBookInheritance() {
    // ensure that getPrice() and getQuantity() have not been overridded
    assertTrue( "Looking for StockItem.getPrice()", hpMethodDetails.contains("StockItem.getPrice()"));
    assertTrue( "Looking for StockItem.getQuantity()", hpMethodDetails.contains("StockItem.getQuantity()"));
    // ensure that inherited methods work properly (i.e. that super() was used correctly)
    assertEquals( "Checking Book prices", bjpPrice, bjp.getPrice(), 1e-9 );
    assertEquals( "Checking Book prices", hpPrice, hp.getPrice(), 1e-9 );
    assertEquals( "Checking Book quantities -- changed one time", hpQty, hp.getQuantity() );
    assertEquals( "Checking Book quantities -- changed two times (look for = vs +=)", bjpQty, bjp.getQuantity() );
  }
  
  /**
   * Tests basic functionality of the toString method in class Book.
   * Similar tests are needed for the CD and DVD classes -- not complete.
   */
  public void testBookToString() {  
    assertTrue( "Looking for Book.toString()", hpMethodDetails.contains("Book.toString()"));
    assertTrue( "Double-check toString...", bjp.toString().contains( bjpTitle ) );
    assertTrue( "Double-check toString...", hp.toString().contains( hpTitle ) );
    assertFalse( "Double-check toString...", hp.toString().contains( bjpTitle ) );
    assertFalse( "Double-check toString...", bjp.toString().contains( hpTitle ) );
    assertTrue( "Double-check toString...", bjp.toString().contains( "Book" ) );
  }
  
  /**
   * Tests basic functionality of the totalItemsInStock method.
   */
  public void testBookStoreBasics() {
    // Using two different objects ensures that 'products' is an instance variable.
    BookStore b1 = new BookStore();
    BookStore b2 = new BookStore();
    b1.addItem(hp);
    b1.addItem(pf);
    b1.addItem(th);
    b2.addItem(thd); // notice this is in b2
    b2.addItem(snf); // notice this is in b2
    b2.addItem(mm);  // notice this is in b2
    b1.addItem(bjp);
    // The method provided in starter code should pass these tests.
    assertEquals( "Total Stock", (hpQty+pfQty+thQty+bjpQty), b1.totalItemsInStock() );
    assertEquals( "Total Stock", (thdQty+snfQty+mmQty), b2.totalItemsInStock() );
  }
  
  /**
   * Tests basic functionality of the productsByPerson method.  Not complete.
   */
  public void testProductsByPerson() {
    // Using two different objects ensures that 'products' is an instance variable.
    BookStore b1 = new BookStore();
    BookStore b2 = new BookStore();
    b1.addItem(hp);
    b2.addItem(pf); // notice this is in b2
    b1.addItem(th);
    b1.addItem(thd);
    b2.addItem(bjp); // notice this is in b2
    b2.addItem(snf); // notice this is in b2
    b1.addItem(mm);
    
    ArrayList<StockItem> jt1 = b1.productsByPerson( jt );
    ArrayList<StockItem> jt2 = b2.productsByPerson( jt );
    assertEquals( "Products by person: no items", 0, jt1.size() );
    assertEquals( "Products by person: two items (artist and actor)", 2, jt2.size() );
    jt1 = b1.productsByPerson( dm );
    assertEquals( "Products by person: one item (character, middle of list)", 1, jt1.size() );
    assertEquals( "Products by person: verify title", hpTitle, jt1.get(0).getTitle() );
    jt1 = b2.productsByPerson( qt );
    assertEquals( "Products by person: one item (director)", 1, jt1.size() );
    assertEquals( "Products by person: verify title", pfTitle, jt1.get(0).getTitle() );
  }
  
  /**
   * Tests basic functionality of the sortByPrice method.  Not complete.
   */
  public void testSortByQuantity() {
    String[] authors = {"test"};
    Book one = new Book("one", authors, 0);
    one.changeQuantity(1);
    Book two = new Book("two", authors, 0);
    two.changeQuantity(2);
    Book three = new Book("three", authors, 0);
    three.changeQuantity(3);
    Book four = new Book("four", authors, 0);
    four.changeQuantity(4);
    Book five = new Book("five", authors, 0);
    five.changeQuantity(5);

    BookStore b1 = new BookStore();
    BookStore b2 = new BookStore();
    // add in this order: 4, 2, 1, 5
    b1.addItem(four); 
    b2.addItem(three);   // notice this item is added to b2
    b1.addItem(two); 
    b1.addItem(one);
    b1.addItem(five); 
    
    // test sortByPrice: first item originally in last position; last initially in middle
    ArrayList<StockItem> test1 = b1.sortedByQuantity();
    assertEquals( "Price Sort Check 2, array length", 4, test1.size() );
    assertEquals( "Price Sort Check 2, 0", 5.0, test1.get(0).getQuantity(), 1e-9 );
    assertEquals( "Price Sort Check 2, 1", 4.0, test1.get(1).getQuantity(), 1e-9 );
    assertEquals( "Price Sort Check 2, 2", 2.0, test1.get(2).getQuantity(), 1e-9 );
    assertEquals( "Price Sort Check 2, 3", 1.0, test1.get(3).getQuantity(), 1e-9 );
  }
  
  /**
   * Tests basic functionality of the sortByTitle method.  Not complete.
   */
  public void testSortByTitle() {
    String[] authors = {"test"};
    Book one = new Book("one", authors, 1);
    Book two = new Book("two", authors, 2);
    Book three = new Book("three", authors, 3);
    Book four = new Book("four", authors, 4);
    Book five = new Book("five", authors, 5);

    BookStore b1 = new BookStore();
    BookStore b2 = new BookStore();
    // add in this order: 4, 2, 1, 5
    b1.addItem(four); 
    b2.addItem(three);  // notice this item is added to b2
    b1.addItem(two); 
    b1.addItem(one);
    b1.addItem(five); 
    
    // test sortByTitle: first item originally in last position; last initially in middle
    StockItem[] test1 = b1.sortedByTitle();
    assertEquals( "Title Sort Check 2, array length", 4, test1.length );
    assertEquals( "Title Sort Check 2, 0", "five", test1[0].getTitle() );
    assertEquals( "Title Sort Check 2, 1", "four", test1[1].getTitle() );
    assertEquals( "Title Sort Check 2, 2", "one", test1[2].getTitle() );
    assertEquals( "Title Sort Check 2, 3", "two", test1[3].getTitle() );
  }
  
}