// Simple example of a Scanner reading from a String.

import java.util.*;

public class StringScannerExample {
    public static void main(String[] args) {
        Scanner input = new Scanner("18.4 17.9 8.3 2.9");
        while (input.hasNextDouble()) {
            double next = input.nextDouble();
            System.out.println(next);
        }
    }
}
