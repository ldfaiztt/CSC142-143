// A program that demonstrates basic queue operations.

import java.util.*;

public class QueueExample {
    public static void main(String[] args) {
        String[] data = {"to", "be", "or", "not", "to", "be"};
        Queue<String> q = new LinkedList<String>();

        for (String str : data) {
            q.add(str);
        }

        System.out.println("queue = " + q);
        System.out.println("size  = " + q.size());
        System.out.println("peek  = " + q.peek());
        while (!q.isEmpty()) {
            System.out.print(q.remove() + " ");
        }
        System.out.println();
    }
}
