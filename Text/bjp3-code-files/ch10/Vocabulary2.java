import java.util.*;
import java.io.*;

public class Vocabulary2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input1 = new Scanner(new File("test1.txt"));
        Scanner input2 = new Scanner(new File("test2.txt"));

        ArrayList<String> list1 = getWords(input1);
        ArrayList<String> list2 = getWords(input2);
        ArrayList<String> overlap = getOverlap(list1, list2);

        System.out.println("list1 = " + list1);
        System.out.println("list2 = " + list2);
        System.out.println("overlap = " + overlap);
    }

    public static ArrayList<String> getWords(Scanner input) {
        // read all words and sort
        ArrayList<String> words = new ArrayList<String>();
        while (input.hasNext()) {
            String next = input.next().toLowerCase();
            words.add(next);
        }
        Collections.sort(words);

        // add unique words to new list and return
        ArrayList<String> result = new ArrayList<String>();
        if (words.size() > 0) {
            result.add(words.get(0));
            for (int i = 1; i < words.size(); i++) {
                if (!words.get(i).equals(words.get(i - 1))) {
                    result.add(words.get(i));
                }
            }
        }
        return result;
    }

    public static ArrayList<String> getOverlap(ArrayList<String> list1,
                                               ArrayList<String> list2) {
        ArrayList<String> result = new ArrayList<String>();
        int index1 = 0;
        int index2 = 0;
        while (index1 < list1.size() && index2 < list2.size()) {
            int comparison = list1.get(index1).compareTo(list2.get(index2));
            if (comparison == 0) {
                result.add(list1.get(index1));
                index1++;
                index2++;
            } else if (comparison < 0) {
                index1++;
            } else {  // comparison > 0
                index2++;
            }
        }
        return result;
    }
}
