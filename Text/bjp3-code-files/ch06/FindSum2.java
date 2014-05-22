// This program adds together a series of numbers from a file.
// It prompts the user for the file name, then reads the file
// and reports the sum.

import java.io.*;
import java.util.*;

public class FindSum2 {
    public static void main(String[] args)
            throws FileNotFoundException {
        System.out.println("This program will add a series");
        System.out.println("of numbers from a file.");
        System.out.println();
        
        Scanner console = new Scanner(System.in);
        System.out.print("What is the file name? ");
        String name = console.nextLine();
        Scanner input = new Scanner(new File(name));
        System.out.println();
        
        double sum = 0;
        while (input.hasNextDouble()) {
            double next = input.nextDouble();
            sum += next;
        }
        System.out.println("Sum = " + sum);
    }
}
