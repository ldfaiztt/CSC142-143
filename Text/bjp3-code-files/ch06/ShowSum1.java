// Program that reads 5 numbers and reports their sum.

import java.io.*;
import java.util.*;

public class ShowSum1 {
    public static void main(String[] args)
            throws FileNotFoundException {
        Scanner input = new Scanner(new File("numbers.dat"));
        
        double sum = 0.0;
        for (int i = 1; i <= 5; i++) {
            double next = input.nextDouble();
            System.out.println("number " + i + " = " + next);
            sum += next;
        }
        System.out.println("Sum = " + sum);
    }
}
