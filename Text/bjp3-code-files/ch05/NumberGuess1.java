// A two-digit number guessing game.

import java.util.*;

public class NumberGuess1 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int number = 42;   // always picks the same number
        
        System.out.print("Your guess? ");
        int guess = console.nextInt();
        int numGuesses = 1;

        while (guess != number) {
            System.out.println("Incorrect.");
            System.out.print("Your guess? ");
            guess = console.nextInt();
            numGuesses++;
        }
        
        System.out.println("You got it right in " + 
                           numGuesses + " tries.");
    }
}
