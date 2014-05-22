import java.util.*;
/**
 * This simple class is part of a two-class demonstration project.
 * To use this class, place this file and the BaseConversion.java file
 * in the same folder on your computer, then open BOTH files in DrJava.
 * 
 * This class creates a simple user interface. This class uses the
 * 'baseConvert' method in class BaseConversion.
 * 
 * @author Chun-Wei Chen
 * @version 10-14-11
 * CSC142.04.F11
 * Assignment #3
 */
public class BaseConversionTool {
  
  /**
   * This user interface accepts two series of integers (an integer and a base)
   * from the user and converts the integer to the base user entered, then
   * shows the equivalent number in the new base. In this version, the user
   * MUST enter a number or the program will crash.
   */
  public static void main(String[] args) {
    
    // simply describe how to use this program
    System.out.print("Welcome to the Demical Convert program. Please enter a postive ");
    System.out.print("integer and base either 2, 8, or 16, then the program will show ");
    System.out.println("the equivalent number in the base you entered. Enter 0 0 to quit.");
    
    Scanner in = new Scanner(System.in); // construct a Scanner to get user input
    System.out.println("Enter an integer and the new base: ");
    int num = in.nextInt(); // get the integer user entered
    int base = in.nextInt(); // get the base user entered
    
    while (num != 0 || base != 0) {
      if (num < 0 && base != 2 && base != 8 && base != 16)
        System.out.println("The number and base are invalid. The number must be >= 0" +
                           " and the base must be either 2, 8, or 16");
      
      else if (num < 0)
      System.out.println("This is an invalid number. The number must be >= 0");
      
      else if (base != 2 && base != 8 && base != 16)
        System.out.println("This is an invalid base. The base must be either 2, 8, or 16");
      
      else {
        String result = BaseConversions.baseConvert(num, base);
        System.out.println(num + " (base-10) equals to " + result + " (base-" + base + ")");
      }
      
      System.out.println("Enter another integer and base. Enter 0 0 to quit");
      num = in.nextInt(); // get another integer user entered
      base = in.nextInt(); // get another base user entered
    }
    System.out.println("Thanks for using the program! Good bye!");
  }
}