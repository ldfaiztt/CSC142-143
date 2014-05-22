import java.util.*;

/**
 * Represents a book stocked by the bookstore.
 * @author Chun-Wei Chen
 * @version 12/10/2011
 */
public class Book extends StockItem
{
  // instance variables
  private String[] authors; // a book may have more than one author
  private String[] characters; // lists some of the main characters
  
  /**
   * Construct a Book object with the specified characteristics
   * @param title the book title
   * @param authors the book authors
   * @param price the list price of this book
   * @throws IllegalArgumentException if title is null, author is null, or price is < 0
   */
  public Book(String title, String[] authors, double price) {
    super(title, price);
    // Precondtion checking
    if (title == null || authors == null)
      throw new IllegalArgumentException("Arguments may nit be null.");
    if (price < 0)
      throw new IllegalArgumentException("The price should be >= 0");
    
    this.authors = copy(authors); // decouple Book object from parameter
    this.characters = new String[0]; // no characters yet
  }
  
  /**
   * Specify the characters for this book.
   * @param characters the main characters in the book
   * @throws IllegalArgumentException if chracters is null
   */
  public void setCharacters(String[] characters) {
    // Precondtion checking
    if (characters == null)
      throw new IllegalArgumentException("Argument may not be null.");
    
    this.characters = copy(characters);
  }
  
  /**
   * Return a list that includes all authors and all characters.
   * @return a list that includes all authors and all characters
   */
  public ArrayList<String> getPeople() {
    ArrayList<String> list = new ArrayList<String> ();
    
    // add authors
    for (String author : authors)
      list.add(author);
    
    // add characters
    for (String character : characters)
      list.add(character);
    
    return list;
  }
  
  /**
   * A string representation of this book. 
   * @return title, authors, number of characters, price, and stock of this book
   */
  public String toString() {
    // add title
    String result = "Book entitled '" + getTitle() + "' ";
    
    // add authors
    if (authors.length == 0)
      result += "with no authors listed";
    else {
      result += "by " + authors[0];
      for(int i = 1; i < authors.length - 1; i++)
        result += ", " + authors[i];
      if (authors.length >= 2)
        result += " and " + authors[authors.length - 1];
    }
    
    // add price
    result += ", list price $" + getPrice();
    
    // add number of characters
    if (characters.length == 0)
      result += ", no characters";
    else if (characters.length == 1)
      result += ", one character";
    else
      result += ", " + characters.length + " characters";
    result += " listed, ";
    
    // add stock
    result += getQuantity() + " in stock.";
    
    return result;
  }
  
  // private String[] copy method
  private String[] copy(String[] s) {
    String[] result = new String[s.length];
    for(int i = 0; i < s.length; i++)
      result[i] = s[i];
    return result;
  }
}