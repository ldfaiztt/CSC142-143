/**
 * This test code demonstrates how the 'finally' clause works in a try/catch block.
 * Three cases are tested:
 *  1. a call to method2 that ends with no exception thrown
 *  2. a call to method2 that causes an IndexOutOfBoundsException to be thown,
 *     and then caught in the try/catch block
 *  3. a call to method2 that causes a NullPointerException to be thrown which is
 *     NOT caught in the try/catch block, and so propagates back to 'main'
 * 
 * In every case, the code in the 'finally' block is executed, even if the 
 * exception thrown in the 'try' block in ultimately not handled.  Notice in the
 * last case that the final 'println' statement is executed AFTER the exception
 * is thrown, even though the program execution terminates because of the
 * unhandled exception.
 * 
 * Even if a 'catch' clause ultimately throws another exception, the 'finally' 
 * clause code will be executed before that exception is thrown.
 * 
 * CSC 143, W'11
 */
public class TestTryCatch
{
  public static void main(String[] args) {
    System.out.println("Start main...");
    method2("Hello", 1);
    method2("Hello", 5);
    method2(null, 0);
    System.out.println("End main.");
  }
  
  public static void method2(String test, int index) {
    try {
      System.out.println("\n  Start method2: test = " + test + "; index = " + index);
      test.charAt(index); // may throw an exception, depending on 'test' and 'index'
      System.out.println("  Normal end of 'try' block in method2 (no exception thrown)");
    } catch (IndexOutOfBoundsException e) {
      System.out.println("    Saw IndexOutOfBoundsException");
    } finally {  // this code is ALWAYS executed
      System.out.println("  'finally' block in method 2");      
    }
    System.out.println("  ...first statement after try/catch block, and end of method2.");
  }
}