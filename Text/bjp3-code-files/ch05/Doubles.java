// This program simulates the rolling of two dice until
// doubles comes up (two dice that are the same).

import java.util.*;

public class Doubles {
    public static void main(String[] args) {
        Random r = new Random();
        int count = 0;
        int roll1, roll2;
        do {
            roll1 = r.nextInt(6) + 1;
            roll2 = r.nextInt(6) + 1;
            System.out.println("next roll = " + roll1 +
                               ", " + roll2);
            count++;
        } while (roll1 != roll2);
        System.out.println("Doubles after " + count +
                           " rolls");
    }
}
