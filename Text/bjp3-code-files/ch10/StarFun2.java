// Sample ArrayList program that builds up a list of words, adds some
// stars to it and then removes them.  This version uses loops that go
// backwards.

import java.util.*;

public class StarFun2 {
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
        for (int i = words.size() - 1; i >= 0; i--) {
            words.add(i, "*");
        }
        System.out.println("after loop words = " + words);

        // remove stars
        for (int i = words.size() - 1; i >= 0; i -= 2) {
            words.remove(i);
        }
        System.out.println("after second loop words = " + words);
    }
}
