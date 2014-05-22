// Counts letter characters in a String.
import java.util.*;   // for Scanner

public class CountLetters {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Type a word: ");
        String s = console.next();
        
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetter(ch)) {
                count++;
            }
        }
        System.out.println("Letters: " + count);
    }
}
