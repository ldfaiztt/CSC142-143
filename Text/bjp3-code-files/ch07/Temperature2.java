// Reads a series of high temperatures and reports the
// average and the number of days above average.

import java.util.*;

public class Temperature2 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("How many days' temperatures? ");
        int numDays = console.nextInt();
        int[] temps = new int[numDays];

        // record temperatures and find average
        int sum = 0;
        for (int i = 0; i < numDays; i++) {
            System.out.print("Day " + (i + 1)
                             + "'s high temp: ");
            temps[i] = console.nextInt();
            sum += temps[i];
        }
        double average = (double) sum / numDays;

        // count days above average
        int above = 0;
        for (int i = 0; i < temps.length; i++) {
            if (temps[i] > average) {
                above++;
            }
        }

        // report results
        System.out.println();
        System.out.println("Average = " + average);
        System.out.println(above + " days above average");
    }
}
