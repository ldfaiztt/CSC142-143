// Variation of Hello3 that prints to a file.

import java.io.*;
import java.util.*;

public class Hello4 {
    public static void main(String[] args)
            throws FileNotFoundException {
        PrintStream output =
            new PrintStream(new File("hello.txt"));
        output.println("Hello world.");
        output.println();
        output.println("This program produces four");
        output.println("lines of output.");
    }
}
