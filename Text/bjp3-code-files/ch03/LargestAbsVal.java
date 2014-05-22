public class LargestAbsVal {
    public static void main(String[] args) {
        System.out.println(largestAbsVal(7, -2, -11));  // 11
        System.out.println(largestAbsVal(-4, 5, 2));    // 5
    }
    
    public static int largerAbsVal(int n1, int n2) {
        return Math.max(Math.abs(n1), Math.abs(n2));
    }

    public static int largestAbsVal(int n1, int n2, int n3) {
        int larger12 = Math.max(Math.abs(n1), Math.abs(n2));
        int larger23 = Math.max(Math.abs(n2), Math.abs(n3));
        return Math.max(larger12, larger23);
    }
}
