// Uses maps to implement a word count, so that the user
// can see which words occur the most in the book Moby Dick.

import java.io.*;
import java.util.*;

public class TopWords {
    // 
    public static final int WORDS = 10;
    
    public static void main(String[] args) 
            throws FileNotFoundException {
        System.out.println("This program displays the most");
        System.out.println("frequently occurring words from");
        System.out.println("a book.");
        System.out.println();
        
        // read the book into a map

	System.out.print("file #1 name? ");
	Scanner input1 = new Scanner(new File(console.nextLine()));
	System.out.print("file #2 name? ");
	Scanner input2 = new Scanner(new File(console.nextLine()));
	System.out.println();
	
        Map<String, Integer> wordCountMap = getCountMap(in);
        
        for (String word : wordCountMap.keySet()) {
            int count = wordCountMap.get(word);
            if (count > OCCURRENCES) {
                System.out.println(word + " occurs " + 
                                   count + " times.");
            }
        }
    }
    
    // Reads book text and returns a map from words to counts
    public static Map<String, Integer> getCountMap(Scanner in,
						   Set<String> top) {
        Map<String, Integer> wordCountMap = 
                new TreeMap<String, Integer>();

        while (in.hasNext()) {
            String word = in.next().toLowerCase();
            if (!wordCountMap.containsKey(word)) {
                // never seen this word before
                wordCountMap.put(word, 1);
            } else {
                // seen this word before; increment count
                int count = wordCountMap.get(word);
                wordCountMap.put(word, count + 1);
            }
        }
        
        return wordCountMap;
    }
}
