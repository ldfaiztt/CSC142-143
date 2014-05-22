/**
 * simple recursive examples
 * I encourage you to make a call to these and trace them by hand, then run
 * the method to make sure your trace was correct.
 **/

public class SimpleRecursion{

  /**
   * recursive method to compute sum of positive integers 1+ 2 +... + y
   * @param y number up to which method should sum
   * precondition: parameter must be >= 0
   * @returns sum of all integers up to and including parameter y
   * @throws IllegalArgumentException for y < 0
   **/ 
    public static int getSum(int y)
    {
      if (y < 0) throw new IllegalArgumentException();
      if ( y == 0)    // the base case stops the recursion
        return 0;
      else 
        return  y + getSum( y - 1 ); // recursive method call
    }

    /**
     * determines if a String is a palindrome
     * @param s the String to evaluate
     * @return true if the String is identical forwards and backwards (including whitespace)
     */
    public static boolean isPalindrome(String s){
      if (s.length() == 0 || s.length() == 1)
        return true;
      else
        return s.charAt(0) == s.charAt(s.length()-1) && isPalindrome(s.substring(1, s.length()-1));
    }
}
