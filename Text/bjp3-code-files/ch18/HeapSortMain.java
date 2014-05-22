// This client program uses a priority queue to perform
// a version of the "heap sort" sorting algorithm.

import java.util.*;

public class HeapSortMain {
    public static void main(String[] args) {
        int[] a = {0, 65, 50, 20, 90, 44, 60, 80, 70, 99, 10};
        heapSort(a);
        System.out.println(Arrays.toString(a));
    }
    
    public static void heapSort(int[] a) {
        Queue<Integer> pq = new PriorityQueue<Integer>();
        for (int n : a) {
            pq.add(n);
        }
        for (int i = 0; i < a.length; i++) {
            a[i] = pq.remove();
        }
    }
}
