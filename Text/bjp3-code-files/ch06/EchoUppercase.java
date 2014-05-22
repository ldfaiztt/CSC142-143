// Reads a file and echos it in uppercase.

import java.io.*;
import java.util.*;

public class EchoUppercase {
    public static void main(String[] args)
            throws FileNotFoundException {
        Scanner input = new Scanner(new File("poem.txt"));
        while (input.hasNextLine()) {
            String text = input.nextLine();
            System.out.println(text.toUpperCase());
        }
    }
}
