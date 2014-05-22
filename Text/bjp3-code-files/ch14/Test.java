import java.util.*;

public class Test {
    public static void main(String[] args) {
        int[] data = {18, 4, 7, 42, 9, 33, -8, 0, 14, 42, 7, 42, 42, 19};
        Queue<Integer> q = new LinkedList<Integer>();
        for (int n : data)
            q.add(n);
        removeAll(q, 42);
        System.out.println("q = " + q);

        int[] data2 = {1, 2, 3, 4, 5, 7, 9, 11};
        int[] data3 = {13, 4, 17, 8, 1, 91, 81, 71};
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        for (int n : data2)
            s1.add(n);
        for (int n : data3)
            s2.add(n);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(sameParityPattern(s1, s2));
        System.out.println(s1);
        System.out.println(s2);
    }

    public static boolean sameParityPattern(Stack<Integer> s1,
                                            Stack<Integer> s2) {
        if (s1.size() != s2.size()) {
            return false;
        } else {
            Stack<Integer> s3 = new Stack<Integer>();
            boolean same = true;
            while (same && !s1.isEmpty()) {
                int num1 = s1.pop();
                int num2 = s2.pop();
                if (num1 % 2 != num2 % 2) {
                    same = false;
                }
                s3.push(num1);
                s3.push(num2);
            }
            while (!s3.isEmpty()) {
                s2.push(s3.pop());
                s1.push(s3.pop());
            }
            return same;
        }
    }
    /*
    public static void removeAll(Queue<Integer> q, int value) {
        for (int i = 0; i < q.size(); i++) {
            int n = q.remove();
            if (n != value) {
                q.add(n);
            }
        }
    }
    */
    public static void removeAll(Queue<Integer> q, int value) {
        int oldSize = q.size();
        for (int i = 0; i < oldSize; i++) {
            int n = q.remove();
            if (n != value) {
                q.add(n);
            }
        }
    }
}
