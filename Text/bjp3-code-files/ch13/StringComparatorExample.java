import java.util.*;

public class StringComparatorExample {
    public static void main(String[] args) {
        String[] strings = {"Foxtrot", "alpha", "echo", "golf", 
                "bravo", "hotel", "Charlie", "DELTA"};

        Arrays.sort(strings, new LengthComparator());
        System.out.println(Arrays.toString(strings));
        
/*
        Arrays.sort(strings, String.CASE_INSENSITIVE_ORDER);
        System.out.println(Arrays.toString(strings));

        Comparator<String> reverse = Collections.reverseOrder(
                String.CASE_INSENSITIVE_ORDER);
        Arrays.sort(strings, reverse);
        System.out.println(Arrays.toString(strings));
*/
    }
}
