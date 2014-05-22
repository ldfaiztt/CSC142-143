/**
 * The EspressoStand class maintains inventory and total sales records for an espresso stand and
 * also processes orders and requests for reports.
 * 
 * @author Chun-Wei Chen
 * @version 11/10/11
 */
public class EspressoStand {
  private int shots, ouncesOfMilk, cookies, cups;
  private double totalSales;
  
  // initialize the price of single short latte, double short latte, double tall latte and cookie
  // as class constants
  public static final double COST_OF_SINGLE_SHORT = 1.99;
  public static final double COST_OF_DOUBLE_SHORT = 2.49;
  public static final double COST_OF_DOUBLE_TALL = 2.99;
  public static final double COST_OF_COOKIE = 1.25;
  
  /**
   * Constructs a new EspressoStand with 1000 shots, 8000 ounces of milk, 1000 cookies, 1000 cups, 
   * and 0 total sales.
   */
  public EspressoStand() {
    shots = 1000;
    ouncesOfMilk = 8000;
    cookies = 1000;
    cups = 1000;
    totalSales = 0;
  }
  
  /**
   * Get the total sales.
   * @return the total sales 
   */
  public double getTotalSales() {
    return totalSales;
  }
  
  /**
   * Show how many shots, ounces of milk, cookies and cups remain in the inventory.
   * @return the inventory report
   */
  public String getInventory() {
    return ("shots: " + shots + "\nounces of milk: " + ouncesOfMilk + 
            "\ncookies: " + cookies + "\ncups: " + cups);
  }
  
  /**
   * This method calculates the price of this order (the argument passed in cannot be null). It updates
   * the number of shots, ounces of milk, cookies and cups in the inventory when the items are sold. 
   * It also updates the total sales to include this order.
   * 
   * @param request an Order
   * @return the price of this order
   * @throws IllegalArgumentException if the request is null
   */
  public double processOrder(Order request) {
    if (request == null) {
      throw new IllegalArgumentException("Argument cannot be null");
    }
    
    // Calculate how many shots, ounces of milk, cookies and cups remain. Each short single latte uses one shot,
    // 8 oz. milk and one cup from the inventory. Each double short latte uses two shots, 8 oz. milk and one cup.
    // Each double tall latte uses two shots, 12 oz. milk and one cup from the inventory.
    shots -= request.getSingleShortCount() + (request.getDoubleShortCount() + request.getDoubleTallCount()) * 2;
    ouncesOfMilk -= (request.getSingleShortCount() + request.getDoubleShortCount()) * 8 + 
                    request.getDoubleTallCount() * 12;
    cookies -= request.getCookieCount();
    cups -= request.getSingleShortCount() + request.getDoubleShortCount() + request.getDoubleTallCount();
    
    double orderPrice = COST_OF_SINGLE_SHORT * request.getSingleShortCount() + 
                        COST_OF_DOUBLE_SHORT * request.getDoubleShortCount() + 
                        COST_OF_DOUBLE_TALL * request.getDoubleTallCount() + 
                        COST_OF_COOKIE * request.getCookieCount();
    
    // Updates the total sales
    totalSales += orderPrice;
    
    return orderPrice;
  }
}