// Demonstrates a Scanner as a parameter to a method that
// can consume an arbitrary number of tokens

import java.io.*;
import java.util.*;

public class ShowSum3 {
    public static void main(String[] args)
            throws FileNotFoundException {
        Scanner input = new Scanner(new File("numbers.dat"));
        processTokens(input, 2);
        processTokens(input, 3);
        processTokens(input, 2);
    }

    public static void processTokens(Scanner input, int n) {
        double sum = 0.0;
        for (int i = 1; i <= n; i++) {
            double next = input.nextDouble();
            System.out.println("number " + i + " = " + next);
            sum += next;
        }
        System.out.println("Sum = " + sum);
        System.out.println();
    }
}
