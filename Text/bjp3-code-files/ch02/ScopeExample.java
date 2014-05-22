// This program does not compile.
public class ScopeExample {
    public static void main(String[] args) {
        int x = 3;
        int y = 7;
        computeSum();
    }
    
    public static void computeSum() {
        int sum = x + y;  // illegal, x/y are not in scope
        System.out.println("sum = " + sum);
    }
}
