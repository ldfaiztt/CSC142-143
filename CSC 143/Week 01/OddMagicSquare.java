import java.util.*;
/**
 * This class asks the user to provide a positive, odd integer to create
 * a magic square, which is a 2-dimensional array to hold the integers.
 * The class also makes use of isMagic method to examine if the magic square
 * remains a magic square after flipped horizontally or vertically.
 * @author Chun-Wei Chen
 * @version 01/10/12
 */
public class OddMagicSquare
{
  
  private int[][] matrix;
  
  /**
   * Construct an n x n magic square.
   * A magic square of order N is an N x N arrangement of the integers from 1 to N * N
   * into rows and columns such that the rows, columns, and the 2 diagonals add up to
   * the same number, N (N * N + 1) / 2.
   * @param n a positive odd integer
   * @throws IllegalArgumentException if the argument is not a positive odd integer
   */
  public OddMagicSquare(int n) {
    if (n < 0 || n % 2 == 0)
      throw new IllegalArgumentException("Argument must be a positive odd integer.");
    
    matrix = new int[n][n];
    
    int count;
    int value = 1; // the starting value
    
    // starting from the middle row, last column
    int rowIdx = n / 2;
    int colIdx = n - 1;
    
    // follow a specific algorithm fill the value into matrix
    // to make it become a magic square.
    // Algorithm: 
    // 1. Starting from the middle row, last column, with the number 1, the fundamental
    // movement for filling the squares is diagonally right and down, one step at a time.
    // 2. If a filled square is encountered, move to the left one square instead,
    // then continue as before.
    // 3. When a move would leave the Magic Square, wrap around.
    for (int i = 0; i < n; i++) {
      count = 0;
      while (count < n) {
        
        // prevent ArrayIndexOutOfBoundException
        if (rowIdx >= n)
          rowIdx = rowIdx % n;
        if (colIdx >= n)
          colIdx = colIdx % n;
        
        matrix[rowIdx][colIdx] = value;
        
        // the fundamental movement for filling the squares is
        // diagonally right and down, one step at a time
        if (count < n - 1) {
          rowIdx++;
          colIdx++;
        }
        
        // if a filled square is encountered, move to the left
        // one square instead, then continue as before
        else {
          if (colIdx - 1 < 0)
            colIdx = n - 1;
          else
            colIdx -= 1;
        }
        value++;
        count++;
      }
    }
  }
  
  /**
   * Get all the value in the matrix of the magic square.
   * @return the copy of the matrix of the magic square
   */
  public int[][] getMatrix() {
    int[][] temp = new int[matrix.length][matrix[0].length];
    
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++)
        temp[i][j] = matrix[i][j];
    }
    return temp;
  }
  
  /**
   * Flip the magic square vertically.
   */
  public void flipVertical() {
    int[] tempRow;
    for (int i = 0; i < matrix.length / 2; i++) {
      tempRow = matrix[i];
      matrix[i] = matrix[matrix.length - 1 - i];
      matrix[matrix.length - 1 - i] = tempRow;
    }
  }
  
  /**
   * Flip the magic square horizontally.
   */
  public void flipHorizontal() {
    int temp;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length / 2; j++) {
        temp = matrix[i][j];
        matrix[i][j] = matrix[i][matrix[i].length - 1 - j];
        matrix[i][matrix[i].length - 1 - j] = temp;
      }
    }
  }
  
  /**
   * String represntation of the magic square.
   * @return magic square in string format, row by row
   */
  public String toString() {
    String result = "";
    
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++)
        result += matrix[i][j] + " ";
      result += "\n";
    }
    return result;
  }
  
  /**
   * Determine if the argument passed in is a magic square.
   * @param m an integer 2-dimensional array
   * @return true if the argument is a magic square
   */
  public static boolean isMagic(int[][] m) {
    int rowIdx, colIdx, sum;
    
    // sum up the value in each row
    for (rowIdx = 0; rowIdx < m.length; rowIdx++) {
      sum = 0;
      for (colIdx = 0; colIdx < m[0].length; colIdx++)
        sum += m[rowIdx][colIdx];
      
      if (sum != m.length * (m.length * m.length + 1) / 2)
        return false;
    }
    
    // sum up the value in each column
    for (colIdx = 0; colIdx < m[0].length; colIdx++) {
      sum = 0;
      for (rowIdx = 0; rowIdx < m.length; rowIdx++)
        sum += m[rowIdx][colIdx];
      
      if (sum != m.length * (m.length * m.length + 1) / 2)
        return false;
    }
    
    // sum up the value in each diagonal
    sum = 0;
    for (rowIdx = 0; rowIdx < m.length; rowIdx++) {
      colIdx = rowIdx;
      sum += m[rowIdx][colIdx];
    }
    if (sum != m.length * (m.length * m.length + 1) / 2)
      return false;
    
    sum = 0;
    for (rowIdx = 0; rowIdx < m.length; rowIdx++) {
      sum += m[rowIdx][colIdx];
      colIdx--;
    }
    if (sum != m.length * (m.length * m.length + 1) / 2)
      return false;
    
    return true;
  }
  
  /**
   * Interact with the user and display the magic square that the user create.
   * Also test another method in this class.
   * @param args
   */
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.print("Please enter a positive odd integer. (0 to quit): ");
    int num = in.nextInt();
    
    while (num != 0) {
      // ask the user to enter a valid input to create a magic square
      while (num < 0 || num % 2 == 0) {
        System.out.print("Invalid input. Please enter a positive odd integer." + 
                          "(0 to quit): ");
        num = in.nextInt();
      }
      OddMagicSquare m = new OddMagicSquare(num);
      System.out.println(m.toString());
      
      // ask the user to enter another value to create another magic square
      System.out.print("Please enter another positive odd integer. (0 to quit): ");
      num = in.nextInt();
    }
    System.out.println("Thanks for using the program!\n");
    
    // test isMagic method
    int[][] i = new int[3][3];
    System.out.println(isMagic(i));
    System.out.println();
    
    // test if a magic square flipped horizontally still remain a magic square
    OddMagicSquare a = new OddMagicSquare(5);
    System.out.println(a.toString());
    a.flipHorizontal();
    System.out.println(a.toString());
    System.out.println(isMagic(a.getMatrix()));
    System.out.println();
    
    // test if a magic square flipped vertically still remain a magic square
    OddMagicSquare b = new OddMagicSquare(7);
    System.out.println(b.toString());
    b.flipVertical();
    System.out.println(b.toString());
    System.out.println(isMagic(b.getMatrix()));
  }
}