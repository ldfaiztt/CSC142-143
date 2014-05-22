
/** class to model an m x n matrix and supports
 * Gaussian row operations
 * <br> In this version, rows and columns start at 0
 * @author csc 142
 * @version 2-15-06
 */
public class Matrix {

  private double[][]matrix;
  
  /**Instantiate a 3 x 4 matrix, empty
  */
  public Matrix() {
     matrix = new double[3][4];
  }
  
  /** Instantiate an m x n matrix, empty
   * @param m number of rows
   * @param n number of columns
   * @throws IllegalArgumentException if either parameter <=0
   */
  public Matrix(int m, int n) {
    if (m > 0 && n > 0)
      matrix = new double[m][n];
    else
      throw new IllegalArgumentException("Parameters must be positive");
  }
  
  /** set the value of a particular element in the matrix
   * @param row the row of the element. 0 <= row < getRowCount()
   * @param col the column of the element. 0 <= col < getColCount()
   * @param value the value to be stored
   * @throws IllegalArgumentException if row or col is illegal
   */
  public void setValue(int row, int col, double value) {
    if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length)
      throw new IllegalArgumentException("Bad row or column");
    else
      matrix[row][col] = value;
  }
  
  /** returns the value of a particular element in the matrix
   * @param row the row of the element. 0 <= row < getRowCount()
   * @param col the column of the element. 0 <= col < getColCount()
   * @throws IllegalArgumentException if row or col is illegal
   */
  public double getValue(int row, int col) {
    if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length)
      throw new IllegalArgumentException("Bad row or column");
    else
      return matrix[row][col];
  }
  
  /** returns the number of rows in this matrix
   */
  public int getRowCount() {
     return matrix.length;
  }
  
  /** returns the number of columns in this matrix
   */
  public int getColCount() {
     return matrix[0].length;
  }

 /** interchange 2 rows of this matrix
   * @param r1 one of the rows to swap.  0 <= r1 < getRowCount()
   * @param r2 the other row to swap.   0 <= r2 < getRowCount()
   * @throws IllegalArguementException for bad arguments
   */
  public void interchangeRows(int r1, int r2) {
    if (r1 < 0 || r1 >= matrix.length || r2 < 0 || r2 >= matrix.length)
      throw new IllegalArgumentException("Rows out of bounds");
    
    // good parameters at this point
    double[] tempRow;
    tempRow = matrix[r1];
    matrix[r1] = matrix[r2];
    matrix[r2] = tempRow;
  }
  
  /** multiply one row by a non-zero constant
   * @param multiple the non-zero constant
   * @param row the row to change
   * @throws IllegalArgumentException if bad arguments
   */
  public void multiplyRow(double multiple, int row) {
    if (row < 0 || row >= matrix.length)
      throw new IllegalArgumentException("Illegal row");
    else if (multiple == 0)
       throw new IllegalArgumentException("Multiple cannot be 0");
    
    for (int i = 0; i <matrix[row].length; i++ )
      matrix[row][i] *= multiple;
  }
  
  /** add row r1 into row r2.  
   * @param r1 the row to add
   * @param r2 the row to add to.  This row will change.
   * @throws IllegalArgumentException for bad rows
   */
  public void addRows (int r1, int r2) {
    if (r1 < 0 || r1 >= matrix.length || r2 < 0 || r2 >= matrix.length)
      throw new IllegalArgumentException("Bad row arguments"); 
    
    for (int i = 0; i < matrix[r1].length; i++)
      matrix[r2][i] += matrix[r1][i];
  }
  
  /** Display the matrix to System.out
   */
  public void display() {
    for ( int i = 0; i < matrix.length; i++) {
      System.out.println();
      for (int j = 0; j < matrix[i].length; j++)
        System.out.print(matrix[i][j] + " ");
    }
  }
}
  
  
  
  
  
  