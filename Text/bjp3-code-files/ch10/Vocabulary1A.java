import java.util.*;
import java.io.*;

public class Vocabulary1A {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input1 = new Scanner(new File("test1.txt"));
        Scanner input2 = new Scanner(new File("test2.txt"));

        ArrayList<String> list1 = getWords(input1);
        ArrayList<String> list2 = getWords(input2);

        System.out.println("list1 = " + list1);
        System.out.println("list2 = " + list2);
    }

    public static ArrayList<String> getWords(Scanner input) {
        ArrayList<String> words = new ArrayList<String>();
        while (input.hasNext()) {
            String next = input.next().toLowerCase();
            if (!words.contains(next)) {
                words.add(next);
            }
        }
        return words;
    }
}
