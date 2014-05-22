import java.awt.Point;
import java.io.*;
import java.util.*;

public class Lists {
    public static void main(String[] args) {
        // timeStutter();

	ArrayList<String> list = new ArrayList<String>();
	list.add("abcd");
	list.add("efgh");
	list.add("abc");
	list.add("123");
	list.add("1234");
	list.add("12345");
	list.add("1234");
	System.out.println(list);

	removeEvenLength(list);
	System.out.println(list);
    }
    
    public static void timeStutter() {
        System.out.printf("%10s %10s (ms)\n", "n", "Runtime");
        for (int n = 1000; n <= 999999999; n *= 2) {
            String[] array = createRandomStringArray(n);
            // ArrayList<String> list = new ArrayList<String>(Arrays.asList(array));
            LinkedList<String> list = new LinkedList<String>(Arrays.asList(array));

            long time = System.currentTimeMillis();
            removeEvenLength(list);
            time = System.currentTimeMillis() - time;
            
            System.out.printf("%10d %10d\n", n, time);
        }
    }

    // Returns the longest string in the given list.
    // pre: list.size() > 0
    public static String longest(List<String> list) {
        Iterator<String> i = list.iterator();
        String result = i.next();
        while (i.hasNext()) {
            String next = i.next();
	    if (i.length() > result.length()) {
		result = next;
	    }
	}
	return result;
    }
    
    // Removes all strings of even length from
    // the given array list.
    public static void removeEvenLength(ArrayList<String> list) {
        int i = 0;
        while (i < list.size()) {
            String element = list.get(i);
            if (element.length() % 2 == 0) {
                list.remove(i);
            } else {
                i++;   // skip to next element
            }
        }
    }

    // Removes all strings of even length from
    // the given linked list.
    public static void removeEvenLength(LinkedList<String> list) {
        Iterator<String> i = list.iterator();
        while (i.hasNext()) {
            String element = i.next();
            if (element.length() % 2 == 0) {
                i.remove();
            }
        }
    }

    public static int[] createRandomIntArray(int size) {
        int[] numbers = new int[size];
        Random rand = new Random();
        int min = rand.nextInt(size);
        int max = rand.nextInt(size - min) + min;
        for (int i = 0; i < size; i++) {
            numbers[i] = rand.nextInt(max - min + 1) + min;
        }
        return numbers;
    }
    
    public static Point[] createRandomPointArray(int size) {
        Point[] points = new Point[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            int x = rand.nextInt(size * 10);
            int y = rand.nextInt(size * 10);
            points[i] = new Point(x, y);
        }
        return points;
    }
    
    public static String[] createRandomStringArray(int size) {
        String[] array = new String[size];
        Random rand = new Random();
        int min = rand.nextInt(size);
        int max = rand.nextInt(size - min) + min;
        for (int i = 0; i < size; i++) {
            array[i] = String.valueOf(rand.nextInt(max - min + 1) + min);
        }
        return array;
    }
}
