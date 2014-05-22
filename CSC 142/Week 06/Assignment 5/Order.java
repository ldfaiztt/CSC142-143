/**
 * The Order class contains the details of an order for an EspressoStand.
 * 
 * @author Chun-Wei Chen
 * @version 11/10/11
 */
public class Order { 
  private int singleShort, doubleShort, doubleTall, cookies;
  
  // Three different constructors
  
  /**
   * The constructor with no parameter constructs a new order for a "Combo #1", which cosists of
   * one single short latte and one cookie.
   */
  public Order() {
    singleShort = 1;
    doubleShort = 0;
    doubleTall = 0;
    cookies = 1;
  }
  
  /**
   * The constructor with two parameters constructs a new order made up of combos.
   * Each "Combo #1" (the first parameter) cosists of one single short latte and one cookie.
   * Each "Combo #2" (the second parameter) cosists of one double tall latte and two cookies.
   * Both quantities in the order must be >= 0.
   * 
   * @param combo1Count the quantity of "Combo #1" servings
   * @param combo2Count the quantity of "Combo #2" servings
   * @throws IllegalArgumentException if combo1Count < 0 or combo2Count < 0
   */
  public Order(int combo1Count, int combo2Count) {
    if (combo1Count < 0 || combo2Count < 0) {
      throw new IllegalArgumentException("Both arguments have to be >= 0");
    }
    
    singleShort = combo1Count;
    doubleTall = combo2Count;
    cookies = combo1Count + combo2Count * 2;
  }
  
  /**
   * The constructor with four parameters constructs a new order made up of single short lattes,
   * double short lattes, double tall lattes and cookies. All the quantities in the order
   * must be >= 0.
   * 
   * @param singleShortCount the quantity of single short lattes in the order
   * @param doubleShortCount the quantity of double short lattes in the order
   * @param doubleTallCount the quantity of double tall lattes in the order
   * @param cookieCount the quantity of cookies in the order
   * @throws IllegalArgumentException if singleShortCount < 0 or
   * doubleShortCount < 0 or doubleTallCount < 0 or cookieCount < 0
   */
  public Order(int singleShortCount, int doubleShortCount, int doubleTallCount, int cookieCount) {
    if (singleShortCount < 0 || doubleShortCount < 0 || doubleTallCount < 0 || cookieCount < 0) {
      throw new IllegalArgumentException("All arguments have to be >= 0");
    }
    
    singleShort =  singleShortCount;
    doubleShort = doubleShortCount;
    doubleTall = doubleTallCount;
    cookies = cookieCount;
  }
  
  /**
   * Get the quantity of single short lattes in the order.
   * @return the quantity of single short lattes
   */
  public int getSingleShortCount() {
    return singleShort;
  }
  
  /**
   * Get the quantity of double short lattes in the order.
   * @return the quantity of double short lattes
   */
  public int getDoubleShortCount() {
    return doubleShort;
  }
  
  /**
   * Get the quantity of double tall lattes in the order.
   * @return the quantity of double tall lattes
   */
  public int getDoubleTallCount() {
    return doubleTall;
  }
  
  /**
   * Get the quantity of cookies in the order.
   * @return the quantity of cookies
   */
  public int getCookieCount() {
    return cookies;
  }
  
  /**
   * The String version of the order.
   * @return the String representation
   */
  public String toString() {
    return ("Ordering:\n" + singleShort +" single-short\n" + doubleShort + " double-short\n" + 
            doubleTall + " double-tall\n" + cookies + " cookies");
  }
}