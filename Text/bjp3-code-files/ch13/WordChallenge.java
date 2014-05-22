// Searches for words in a dictionary text file
// and reports each word's position in the file.

import java.io.*;
import java.util.*;

public class WordChallenge {
    public static void main(String[] args)
            throws FileNotFoundException {
        System.out.println("Welcome to Scrabble word challenge!");

        // read a sorted dictionary file into a List
        Scanner in = new Scanner(new File("words.txt"));
        List<String> words = new ArrayList<String>();
        while (in.hasNext()) {
            String word = in.next();
            words.add(word);
        }

        // binary search the list for words
        Scanner console = new Scanner(System.in);
        System.out.print("Word to challenge (Enter to quit)? ");
        String target = console.nextLine();
        while (target.length() > 0) {
            int index = Collections.binarySearch(words, target);
            if (index >= 0) {
                System.out.println("\"" + target + "\" is word #"
                        + index + " of " + words.size());
            } else {
                System.out.println("\"" + target + "\" is not found");
            }
            
            System.out.print("Word to challenge (Enter to quit)? ");
            target = console.nextLine();
        }
    }
}