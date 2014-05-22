// Builds up a list of words, adds stars to it and removes them.

import java.util.*;

public class StarFun {
    public static void main(String[] args) {
    // construct and fill up ArrayList
    ArrayList<String> words = new ArrayList<String>();
    words.add("four");
    words.add("score");
    words.add("and");
    words.add("seven");
    words.add("years");
    words.add("ago");
    System.out.println("words = " + words);

    // insert one star in front of each word
    for (int i = 0; i < words.size(); i += 2) {
        words.add(i, "*");
    }
    System.out.println("after loop words = " + words);

    // remove stars
    for (int i = 0; i < words.size(); i++) {
        words.remove(i);
    }
    System.out.println("after second loop words = " + words);
    }
}
