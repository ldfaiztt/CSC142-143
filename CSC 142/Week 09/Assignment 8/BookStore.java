import java.util.*;

/**
 * Manages the product information for a bookstore.
 * @author Chun-Wei Chen
 * @version 12/10/2011
 */
public class BookStore
{
  // instance variables
  private ArrayList<StockItem> products; // all the stock item contained in bookstore
  
  /**
   * Construct a new BookStore with no products.
   */
  public BookStore() {
    products = new ArrayList<StockItem>();
  }
  
  /**
   * Add an item to the list of products.
   * @param newItem the item to add to the list
   * @throws IllegalArgumentException if newItem is null
   */
  public void addItem(StockItem newItem) {
    // Precondtion checking to prevent 'null' being added to the list.
    if (newItem == null)
      throw new IllegalArgumentException("Argument may not be null.");
    
    products.add(newItem);
  }
  
  /**
   * Returns the total number of items in stock.
   * @return the total number of items in stock
   */
  public int totalItemsInStock() {
    int count = 0;
    for (int i = 0; i < products.size(); i++) {
      StockItem item = products.get(i); // get a reference to the next item
      count = count + item.getQuantity(); // count the quantity of that item
    }
    return count;
  }
  
  /**
   * Create a new array and fill it with references to each stock item, and then
   * sort the array (insertion sort) in alphabetical order by title, ignoring case
   * @return the array sorted in alphabetical order by title, ignoring case
   */
  public StockItem[] sortedByTitle() {
    // copy the elements from products
    StockItem[] result = new StockItem[products.size()];
    for (int i = 0; i < result.length; i++)
      result[i] = products.get(i);
    
    // insertion sort
    for (int idx = 1; idx < result.length; idx++) {
      StockItem temp = result[idx];
      int j;
      for (j = idx; j > 0 && 
           temp.getTitle().compareToIgnoreCase(result[j - 1].getTitle()) < 0; j--)
        result[j] = result[j - 1];
      result[j] = temp;
    }
    return result;
  }
  
  /**
   * Create a new ArrayList and fill it with references to each stock item, and then
   * sort the list (selection sort) in descending order by quantity
   * @return the ArrayList<StockItem> sorted in descending order by quantity
   */
  public ArrayList<StockItem> sortedByQuantity() {
    // copy the elements from products
    ArrayList<StockItem> result = new ArrayList<StockItem>();
    for (int i = 0; i < products.size(); i++)
      result.add(products.get(i));
    
    // selection sort
    for (int i = 0; i < result.size() - 1; i++) {
      int idxHighest = i;
      for (int j = i + 1; j < result.size(); j++) {
        if (result.get(j).getQuantity() > result.get(i).getQuantity())
          idxHighest = j;
      }
      StockItem temp = result.set(i, result.get(idxHighest));
      result.set(idxHighest, temp);
    }
    return result;
  }
  
  /**
   * Create a new ArrayList and adds all stock items that have associated with 
   * the person to it.
   * @param person the person as a parameter to find all the stock items
   * accociated with him or her
   * @return all the stock items associated with the person
   * @throws IllegalArgumentException if person is null
   */
  public ArrayList<StockItem> productsByPerson(String person) {
    // Precondtion checking
    if (person == null)
      throw new IllegalArgumentException("Argument may not be null.");
    
    ArrayList<StockItem> result = new ArrayList<StockItem>();
    // go through all the stock items to find out
    // the stock item accociated with the person
    for (int i = 0; i < products.size(); i++) {
      if (products.get(i).getPeople().contains(person))
        result.add(products.get(i));
    }
    return result;
  }
  
  /////////////////////// TEST SECTION /////////////////////////
  
  public static void main(String[] args) {
    // Construct a BookStore object
    BookStore myStore = new BookStore();
    
    // Create first book
    String[] jkr = {"J.K. Rowling"};
    Book hp = new Book("Harry Potter and the Chamber of Secrets", jkr, 24.95);
    String[] hpChar = {"Harry Potter", "Hermione Granger", "Ron Weasley", 
      "Rubeus Hagrid", "Draco Malfoy", "Albus Dumbledore"};
    hp.setCharacters(hpChar);
    hp.changeQuantity(1000);
    
    // Create second book
    String[] rs = {"Stuart Reges", "Marty Stepp"};
    Book bjp = new Book("Building Java Programs", rs, 113.00);
    // note: no characters to set
    bjp.changeQuantity(40);
    
    // Add books to the BookStore inventory
    myStore.addItem(bjp);
    myStore.addItem(hp);
    
    System.out.println( "BookStore initialized.  Total items in stock: "
                         + myStore.totalItemsInStock() );
  }
}