// Reads an input file of numbers, showing the numbers and
// their sum.

import java.io.*;
import java.util.*;

public class ShowSum2 {
    public static void main(String[] args)
            throws FileNotFoundException {
        Scanner input = new Scanner(new File("numbers.dat"));
        
        double sum = 0.0;
        int count = 0;
        while (input.hasNextDouble()) {
            double next = input.nextDouble();
            count++;
            System.out.println("number " + count + " = "
                               + next);
            sum += next;
        }
        System.out.println("Sum = " + sum);
    }
}
