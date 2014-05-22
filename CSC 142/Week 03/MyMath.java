/**
 * This simple class is part of a two-class demonstration project.
 * To use this class, place this file and the TestMyMath.java file
 * together in the same folder on your computer, then open BOTH 
 * files in DrJava.
 * 
 * This is an example of a class that provides tools that can be
 * used by other classes, just like the Math class built into Java.
 * 
 * @author csc142
 * @version Fall 2010
 */
public class MyMath
{
  /**
   * Computes the cube root of a number. 
   * @param num the number to work with -- must be >= 0
   * @return the cube root of num
   */
  public static double cubeRoot(double num) {
    if (num < 0)
      throw new IllegalArgumentException("The argument must be >= 0");
    double ans = Math.pow(num, 1.0/3.0);
    return ans;
  }
}

/*
 * Notice that this class does not contain a 'main' method.  This means
 * that you will not be able to click 'Run' in DrJava.  You can test the
 * cubeRoot method by writing statement in DrJava's "Interactions Pane" 
 * that CALL the method.  Since this is a static method, the qualifier
 * in the method call must be the name of the class.  Here's an example:
 * 
 * double result = MyMath.cubeRoot(27);
 * 
 * When you are designing the solution to a larger programming application,
 * it is often valuable to break that large task down into smaller tasks.
 * Frequently these self-contained sub-tasks will be coded as independent
 * methods like the cubeRoot method above.  It is good practice to test
 * and debug each independent method to make sure they work before you try
 * to join everything together in the final program.
 */