/**
 * This simple class is part of a two-class demonstration project.
 * To use this class, place this file and the BaseConversion.java file
 * together in the same folder on your computer, then open BOTH files in DrJava.
 * 
 * This class provides a tool that can be used by other classes,
 * just like the Math class built into Java.
 * 
 * @author Chun-Wei Chen
 * @version 10-14-11
 * CSC142.04.F11
 * Assignment #3
 */
public class BaseConversions {
  
  /**
   * Computes the positive integer (base-10) to either base 2, 8, or 16 
   * @param num the number must be type int and >= 0
   * @return the the equivalent number in new base
   */
  public static String baseConvert(int num, int base) {
    String result = ""; // initialize the result first in order to return it at the end
    
    // the case if the number and the base are both invalid
    if (num < 0 && (base < 0 || base != 2 && base != 8 && base != 16))
      throw new IllegalArgumentException("The number must be >= 0 and the base " +
                                           "should be either 2, 8, or 16");
    // the case if the number is invalid
    else if (num < 0)
        throw new IllegalArgumentException("The number must be >= 0");
    
    // the case if the base is invalid
    else if (base < 0 || base != 2 && base != 8 && base != 16)
        throw new IllegalArgumentException("The base must be either 2, 8, or 16");
    
    // the case that converts to base-2 
    else if (base == 2) {
      while (num != 0) {
        result = num % 2 + result;
        num /= 2; // update
      }
    }
    
    // the case that converts to base-8
    else if (base == 8) {
      while (num != 0) {
        result = num % 8 + result;
        num /= 8; // update
      }
    }
    
    // the case that converts to base-16
    else {
      while (num != 0) {
        String letter;
        if (num % 16 == 10) {
          letter = "A";
          result = letter + result;
        }
        else if (num % 16 == 11) {
          letter = "B";
          result = letter + result;
        }
        else if (num % 16 == 12) {
          letter = "C";
          result = letter + result;
        }
        else if (num % 16 == 13) {
          letter = "D";
          result = letter + result;
        }
        else if (num % 16 == 14) {
          letter = "E";
          result = letter + result;
        }
        else if (num % 16 == 15) {
          letter = "F";
          result = letter + result;
        }
        else {
          result = num % 16 + result;
        }
        num /= 16; // update
      }
    }
    
    // the case that number user entered is 0
    if (result == "")
      result = "0";
    
    return result;
  }
}