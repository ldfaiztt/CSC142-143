/**
 * Code written in class on Wednesday, 10/26/11.
 * Comments are very limited because of the dynamic way
 * we developed this code.
 */
public class ArrayTest
{
  public static void main(String[] args) {
    // code to test the various methods...
    double[] prices = {74.5, 18.6, 39, 52.1, 87};
    int[] vec1 = {-4, 5, 6};
    int[] vec2 = {12, -2, 7};
    printArray(prices);
    raisePrices(prices, 10);
    printArray(prices);
    double[] ans = calcRaisedPrices(prices, 10);
    printArray(ans);
    printArray(prices);
    printArray(vec1);
    printArray(vec2);
    int[] vec3 = vectorSum(vec1, vec2);
    printArray(vec3);
    double[] diff = differences(prices);
    printArray(diff);
    double[] sub = subArray(prices, 1, 3);
    printArray(sub);
    
    //System.out.println(java.awt.Color.RED);
    
    String[] fruits = {"apple", "banana", "cantalopue", "durian", "dates"};
    String[] f = findByFirstLetter(fruits, 'g');
    System.out.println(f.length);
  }
 
  public static String[] findByFirstLetter(String[] arr, char c) {
    int count = 0;
    for (int i = 0; i < arr.length; i++)
      if (arr[i].charAt(0) == c)
        count++;
    String[] result = new String[count];
    count = 0;
    for (int i = 0; i < arr.length; i++)
      if (arr[i].charAt(0) == c)
        result[count++] = arr[i];
    return result;
  }
 
  public static double[] subArray(double[] arr, int start, int stopBefore) {
    if (start < 0 || start >= arr.length
          || stopBefore < start || stopBefore > arr.length)
      throw new IllegalArgumentException();
    double[] result = new double[stopBefore - start];
    for (int i = start; i < stopBefore; i++)
      result[i - start] = arr[i];
    return result;
  }
 
  // Changes the array 'prices'
  public static void raisePrices(double[] arr, double percentage) {
    for (int i = 0; i < arr.length; i++) {
      arr[i] = arr[i] + arr[i] * percentage / 100;
    }
  }
 
  // Does NOT change 'prices'
  public static double[] calcRaisedPrices(double[] arr, double percentage) {
    double[] result = new double[arr.length];
    for (int i = 0; i < arr.length; i++) {
      result[i] = arr[i] + arr[i] * percentage / 100;
    }
    return result;
  }
 
  // differences from one element to the next
  public static double[] differences(double[] a) {
    if (a.length < 2)
      throw new IllegalArgumentException();
    double[] result = new double[a.length-1];
    for (int i = 0; i < a.length-1; i++) {
      result[i] = a[i+1] - a[i];
    }
    return result;
  }
 
  public static int[] vectorSum(int[] a, int[] b) {
    if (a.length != b.length)
      throw new IllegalArgumentException();
    int[] result = new int[a.length];
    for (int i = 0; i < a.length; i++) {
      result[i] = a[i] + b[i];
    }
    return result;
  }
 
  // Fencepost pattern; OVERLOADED methods
  public static void printArray(int[] x) {
    if (x.length == 0)
      System.out.println("{}");
    String s = "{" + x[0];
    for (int i = 1; i < x.length; i++) {
      s += "," + x[i];
    }
    System.out.println(s + "}");
  }
 
  // Fencepost pattern; OVERLOADED methods
  public static void printArray(double[] x) {
    if (x.length == 0)
      System.out.println("{}");
    else {
      String s = "{" + x[0];
      for (int i = 1; i < x.length; i++) {
        s += "," + x[i];
      }
      System.out.println(s + "}");
    }
  }
}