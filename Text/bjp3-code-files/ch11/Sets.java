import java.awt.Point;
import java.io.*;
import java.util.*;

public class Sets {
    public static void main(String[] args) throws FileNotFoundException {
        // timeStutter();
        countWords();
	System.out.println();
	countWords2();
	System.out.println();

        Set<Point> set = new TreeSet<Point>();
        set.add(new Point(5, 2));
        set.add(new Point(2, 1));
        set.add(new Point(3, 9));
        System.out.println(set.contains(new Point(5, 2)));
    }
    
    // Returns the number of elements contained in both set1 and set2.
    public static int totalElements(Set<String> set1, Set<String> set2) {
        Set<String> union = new HashSet<String>(set1);
        union.addAll(set2);
        return union.size();
    }
    
    // Returns true if the given list contains any duplicate elements.
    public static boolean hasDuplicates(List<Integer> list) {
        Set<Integer> set = new HashSet<Integer>(list);
        return set.size() < list.size();
    }
    
    // Counts unique words in Moby Dick.
    public static void countWords() throws FileNotFoundException {
        Set<String> words = new HashSet<String>();
        Scanner in = new Scanner(new File("mobydick.txt"));
        while (in.hasNext()) {
            String word = in.next();
            word = word.toLowerCase();
            words.add(word);
        }
        System.out.println("Number of unique words = " + words.size());
    }

    public static void countWords2() throws FileNotFoundException {
        Set<String> words = new TreeSet<String>();
        Scanner in = new Scanner(new File("mobydick.txt"));
        while (in.hasNext()) {
            String word = in.next();
            word = word.toLowerCase();
            if (word.startsWith("a") && word.length() == 3) {
                words.add(word);
            }
        }
        System.out.println("Three-letter 'a' words = " + words);
    }
    
    
    // .replaceAll("[^a-z]", "");
    
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
    
    // Removes all strings of even length from
    // the given array list.
    public static void removeEvenLength(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i += 2) {
            String element = list.get(i);
            if (element.length() % 2 == 0) {
                list.remove(i);
                i--;
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
