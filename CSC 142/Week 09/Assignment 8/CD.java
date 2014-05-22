import java.util.*;

/**
 * Represents a CD stocked by the bookstore.
 * @author Chun-Wei Chen
 * @version 12/10/2011
 */
public class CD extends StockItem
{
  // instance variables
  private String artist; // the artist of the CD
  private String producer; // the producer of the CD
  
  /**
   * Construct a Book object with the specified characteristics
   * @param title the CD title
   * @param artist the CD artist
   * @param producer the CD producer
   * @param price the list price of this CD
   * @throws IllegalArgumentException if title is null, artist is null,
   * author is null, or price is < 0
   */
  public CD (String title, String artist, String producer, double price) {
    super(title, price);
    // Precondtion checking
    if (title == null || artist == null || producer == null)
      throw new IllegalArgumentException("Arguments may nit be null.");
    if (price < 0)
      throw new IllegalArgumentException("The price should be >= 0");
    
    this.artist = artist;
    this.producer = producer;
  }
  
  /**
   * Get the artist for this CD.
   * @return the artist of this CD
   */
  public String getArtist() {
    return artist;
  }
  
  /**
   * Get the producer for this CD.
   * @return the producer of this CD
   */
  public String getProducer() {
    return producer;
  }
  
  /**
   * A string representation of this CD.
   * @return title, artist, producer, price, and stock of this CD
   */
  public String toString() {
    // add title
    String result = "CD entitled '" + getTitle() + "' ";
    
    // add artist
    if (artist.length() == 0)
      result += "with no artist listed";
    else
      result += "by " + getArtist();
    
    // add producer
    if (producer.length() == 0)
      result += ", no producer listed";
    else
      result += ", produced by " + getProducer();
    
    // add price
    result += ", list price $" + getPrice();
    
    // add stock
    result += ", " + getQuantity() + " in stock.";
    
    return result;
  }
  
   /**
   * Return a list that contains the artist and the producer.
   * @return a list that contains the artist and the producer
   */
  public ArrayList<String> getPeople() {
    ArrayList<String> list = new ArrayList<String> ();
    
    // add artist
    if (artist.length() > 0)
      list.add(artist);
    
    // add producer
    if (producer.length() > 0)
      list.add(producer);
    
    return list;
  }
}