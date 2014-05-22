// Uses maps to implement a word count, so that the user
// can see which words occur the most in the book Moby Dick.

import java.io.*;
import java.util.*;

public class WordCount {
    // minimum number of occurrences needed to be printed
    public static final int OCCURRENCES = 2000;
    
    public static void main(String[] args) 
            throws FileNotFoundException {
        System.out.println("This program displays the most");
        System.out.println("frequently occurring words from");
        System.out.println("the book Moby Dick.");
        System.out.println();
        
        // read the book into a map
        Scanner in = new Scanner(new File("mobydick.txt"));
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
    public static Map<String, Integer> getCountMap(Scanner in) {
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
