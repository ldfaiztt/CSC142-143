// This client program tests our priority queue of integers
// by adding and removing several elements from it.

public class HeapMain {
    public static void main(String[] args) {
        HeapIntPriorityQueue pq = new HeapIntPriorityQueue();
        int[] elements = {65, 50, 20, 90, 44, 60, 80, 70, 99, 10};
        for (int n : elements) {
            pq.add(n);
            System.out.println(pq);
        }
        
        // System.out.println(pq);
        while (!pq.isEmpty()) {
            System.out.println(pq.remove());
            System.out.println(pq + ", size "+ pq.size());
        }
    }
}
