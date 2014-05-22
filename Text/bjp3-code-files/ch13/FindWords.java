// Searches for a word in a dictionary text file
// and reports that word's position in the file.

import java.io.*;
import java.util.*;

public class FindWords {
    public static void main(String[] args) 
            throws FileNotFoundException {
        // read sorted dictionary file into an ArrayList
        Scanner in = new Scanner(new File("words.txt"));
        ArrayList<String> words = new ArrayList<String>();
        while (in.hasNext()) {
            String word = in.next();
            words.add(word);
        }
        
        // binary search the list for a particular word
        System.out.print("Your word? ");
        Scanner console = new Scanner(System.in);
        String target = console.nextLine();
        
        int index = Collections.binarySearch(words, target);
        if (index >= 0) {
            System.out.println(target + " is word #" + index);
        } else {
            System.out.println(target + " is not found");
        }
    }
}
