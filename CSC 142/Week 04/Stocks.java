import java.io.*;
import java.util.*;

/**
 * This program reads and analyze some stock transaction data from a file,
 * then show a short report to the console.
 * 
 * @author Chun-Wei Chen
 * @version 10/21/11
 */
public class Stocks {
  public static void main(String[] args) throws FileNotFoundException {
    File data = new File("trades2.txt");
    Scanner text = new Scanner(data);
    // Initialize some variables which will be used during the loop and after the loop
    int count = 0;
    double total = 0;
    String highestPriceSymbol = "";
    int highestValueQuantity = 0;
    double highestPrice = 0;    
    
    // Use the loop to read and analyze the file record by record 
    while (text.hasNext()) {
      // Store the stock symbol, the number of shares traded, and the trading price of each record
      String name = text.next();
      int quantity = text.nextInt();
      double price = text.nextDouble();
      double transaction = quantity * price;
      total += transaction;
      
      // Show the stock symbol, the number of shares traded, and the trading price if the
      // value of the stock is less than or equal to $30000
      if (quantity * price <= 30000)
        System.out.printf("%s %d %.2f -- the value of this stock is $%.2f, less than $30000.\n",
                          name, quantity, price, transaction);
      
      // Find the stock wich has the highest trading price
      if (price > highestPrice) {
        highestPriceSymbol = name;
        highestValueQuantity = quantity;
        highestPrice = price;
      }
      count += 1; // count the number of transactions
    }
    
    // Show a short report about the file
    System.out.printf("%s %d %.2f -- this stock has the highest trading price in " + data + ".\n", 
                      highestPriceSymbol, highestValueQuantity, highestPrice);
    System.out.println("There are " + count + " transactions listed in " + data + ".");
    System.out.printf("The toatl value of all stock trades listed in " + data + " is $%.2f.\n", total);
  }
}
    