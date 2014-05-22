/*
 * IMPORTANT: Do not change this file.  Use this file in your project
 * exactly as provided here.
 */

import java.util.*;

/**
 * The top-level class for all items stocked by the BookStore.
 * STARTER CODE for Assignment #8.
 * @author CSC 142
 * @version 11/28/2011
 */
public abstract class StockItem 
{
  // instance variables
  private String title; // every item has a title
  private int quantity; // quantity in stock
  private double listPrice; // the list price of this item
  
  /**
   * Constructor to be used by subclasses
   * @param title the title of this item
   * @param price the list price of this item
   */
  public StockItem( String title, double price ) {
    this.title = title;
    quantity = 0;
    listPrice = price;
  }
  
  /**
   * Get the quantity in stock.
   * @return the quantity in stock
   */
  public int getQuantity() {
    return quantity;
  }
  
  /**
   * Get the title.
   * @return the title of this item
   */
  public String getTitle() {
    return title;
  }
  
  /**
   * Get the price for this item.
   * @return the list price
   */
  public double getPrice() {
    return listPrice;
  }
  
  /**
   * Change the quantity in stock by the amount specified
   * (a positive number increases the stock; negative decreases).
   * Throws an IllegalArgumentException if the change would
   * make the new quantity negative.
   * @param amount the amount by which to change the quantity
   */
  public void changeQuantity(int amount) {
    if (quantity + amount < 0 )
      throw new IllegalArgumentException("Insufficient stock");
    quantity += amount;
  }
  
  /**
   * Get a list of all the people associated with this stock
   * item.  Varies depending on the type of stock item, but
   * might include authors, artists, characters, cast members,
   * producers, etc.
   * @return the list of people as an ArrayList<String>
   */
  public abstract ArrayList<String> getPeople();
  
}