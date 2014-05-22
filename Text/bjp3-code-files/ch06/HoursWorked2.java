// Variation of HoursWorked that includes employee ids.

import java.io.*;
import java.util.*;

public class HoursWorked2 {
    public static void main(String[] args)
            throws FileNotFoundException {
        Scanner input = new Scanner(new File("hours2.dat"));
        while (input.hasNextLine()) {
            String text = input.nextLine();
            processLine(text);
        }
    }
    
    // Processes the given String (id, name and hours worked)
    public static void processLine(String text) {
        Scanner data = new Scanner(text);
        int id = data.nextInt();
        String name = data.next();
        double sum = 0.0;
        while (data.hasNextDouble()) {
            sum += data.nextDouble();
        }
        System.out.println("Total hours worked by " + name + 
                           " (id#" + id + ") = " + sum);
    }
}
