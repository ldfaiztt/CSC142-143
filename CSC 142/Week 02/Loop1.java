/*
 *
 */
public class Loop1 {
  public static final double R_MULT = 100.0;
 
  public static void main(String[] args) {
    loopA();
    double answer = mangle(3, 1.2);
    System.out.println("The answer is " + answer);
    System.out.println("The second answer is "
                         + mangle(-4, 0.2));
  }
 
  public static double mangle(int a, double b) {
    double result = 6 + a * b;
    return result;
  }
 
  public static void loopA() {
    final int limit = 3;
    int i;
    System.out.print("{0.0"); // INITIALIZATION
    for (i = 0; i < limit; i++) {
      double num = (i + 1) * 0.11;
      num = Math.round(num * R_MULT) / R_MULT; // round to one place
      System.out.print(", " + num);
    }
    System.out.println("} " + i); // FINALIZATION
  }
}