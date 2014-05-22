import java.util.*;

/**
 * Represents a DVD stocked by the bookstore.
 * @author Chun-Wei Chen
 * @version 12/10/2011
 */
public class DVD extends StockItem
{
  // instance variables
  private String director; // the director of the DVD
  private ArrayList<String> cast; // a list of the cast of the DVD
  
  /**
   * Construct a DVD object with the specified characteristics
   * @param title the DVD title
   * @param director the DVD director
   * @param price the list price of this DVD
   * @throws IllegalArgumentException if title is null, director is null, or price is < 0
   */
  public DVD (String title, String director, double price) {
    super(title, price);
    // Precondtion checking
    if (title == null || director == null)
      throw new IllegalArgumentException("Arguments may not be null.");
    if (price < 0)
      throw new IllegalArgumentException("The price should be >= 0");
    
    this.director = director;
    this.cast = new ArrayList<String>();
  }
  
  /**
   * Get the director for this DVD.
   * @return the director of this DVD
   */
  public String getDirector() {
    return director;
  }
  
  /**
   * A string representation of this DVD.
   * @return title, director, number of cast members, price, and stock of this DVD
   */
  public String toString() {
    // add title
    String result = "DVD entitled '" + getTitle() + "' ";
    
    // add director
    if (director.length() == 0)
      result += "with no director listed";
    else
      result += "directed by " + getDirector();
    
    // add number of cast members
    if (cast.size() == 0)
      result += ", 0 cast member listed";
    else
      result += ", " + cast.size() + " cast members listed";
    
    // add price
    result += ", list price $" + getPrice();
    
    // add stock
    result += ", " + getQuantity() + " in stock.";
    
    return result;
  }
  
  /**
   * Return a list that includes the director and all cast members.
   * @return a list that includes the director and all cast members.
   */
  public ArrayList<String> getPeople() {
    ArrayList<String> list = new ArrayList<String>();
    
    // add director
    if (director.length() > 0)
      list.add(director);
    
    // add cast members
    for (String s : cast)
      list.add(s);
    
    return list;
  }
  
  /**
   * Specify the cast members for this DVD.
   * @param cast the cast members in the DVD
   * @throws IllegalArgumentException if cast is null
   */
  public void setCast(String[] cast) {
    // Precondtion checking
    if (cast == null)
      throw new IllegalArgumentException("Argument may not be null.");
    
    String[] newCast = copy(cast);
    for (int i = 0; i < newCast.length; i++)
      this.cast.add(newCast[i]);
  }
  
  // private String[] copy method
  private String[] copy(String[] s) {
    String[] result = new String[s.length];
    for (int i = 0; i < s.length ; i++)
      result[i] = s[i];
    return result;
  }
}