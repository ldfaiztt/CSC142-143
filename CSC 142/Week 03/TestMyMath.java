import java.util.Scanner;
/**
 * This simple class is part of a two-class demonstration project.
 * To use this class, place this file and the MyMath.java file
 * together in the same folder on your computer, then open BOTH 
 * files in DrJava.
 * 
 * This is an example of a class that creates a simple user
 * interface.  This class USES (is a "client" of) the 'cubeRoot'
 * method in class MyMath.  Separating code that creates a user
 * interface from code that performs computations and other tasks
 * is good design practice.
 * 
 * @author csc142
 * @version Fall 2010
 */
public class TestMyMath
{
  /**
   * This is a simple user interface that accepts a series of 
   * numbers from the user and shows the cube root of each 
   * number.  In this version, the user MUST enter a number
   * or the program will crash.  In a future version, we'll 
   * see how we can handle the situation where the user enters
   * something other than a number by mistake.
   */
  public static void main(String[] args) {
    
    Scanner in = new Scanner(System.in); // construct a Scanner to get user input
    System.out.println("This program will calculate the cube root of each number"
                        + " you enter.  Be sure to enter only numbers.\n");
    System.out.print("Enter a positive number, or a number <= 0 to quit: ");
    double x = in.nextDouble();
    while ( x > 0.0 ) {
      double root = MyMath.cubeRoot(x);
      root = Math.round(root * 1000.0) / 1000.0;  // round result to 3 places
      System.out.println("The cube root of " + x + " is " + root + "\n");
      System.out.print("Enter another positive number, or a number <= 0 to quit: ");
      x = in.nextDouble();
    }
    System.out.println("Good-bye");
  }
}
