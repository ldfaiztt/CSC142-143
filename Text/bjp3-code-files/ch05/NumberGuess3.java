// A robust two-digit number-guessing game with hinting.

import java.util.*;

public class NumberGuess3 {
    public static void main(String[] args) {
        giveIntro();
        Scanner console = new Scanner(System.in);
        
        // pick a random number from 0 to 99 inclusive
        Random rand = new Random();
        int number = rand.nextInt(100);
        
        // get first guess
        int guess = getGuess(console);
        int numGuesses = 1;

        // give hints until correct guess is reached
        while (guess != number) {
            int numMatches = matches(number, guess);
            System.out.println("Incorrect (hint: " +
                               numMatches + " digits match)");
            guess = getGuess(console);
            numGuesses++;
        }
        
        System.out.println("You got it right in " +
                           numGuesses + " tries.");
    }
    
    // Displays an introduction message to the user.
    public static void giveIntro() {
        System.out.println("Try to guess my two-digit");
        System.out.println("number, and I'll tell you how");
        System.out.println("many digits from your guess");
        System.out.println("appear in my number.");
        System.out.println();
    }
    
    // Returns # of matching digits between the two numbers.
    // pre: number and guess are unique two-digit numbers
    public static int matches(int number, int guess) {
        int numMatches = 0;

        if (guess / 10 == number / 10 || 
            guess / 10 == number % 10) {
            numMatches++;
        }
        
        if (guess / 10 != guess % 10 && 
            (guess % 10 == number / 10 || 
             guess % 10 == number % 10)) {
            numMatches++;
        }
        
        return numMatches;
    }
    
    // Re-prompts until a number in proper range is entered.
    // post: guess is between 0 and 99
    public static int getGuess(Scanner console) {
        int guess = getInt(console, "Your guess? ");
        while (guess < 0 || guess >= 100) {
            System.out.println("Out of range; try again.");
            guess = getInt(console, "Your guess? ");
        }
        
        return guess;
    }
    
    // Re-prompts until a number is entered.
    public static int getInt(Scanner console, String prompt) {
        System.out.print(prompt);
        while (!console.hasNextInt()) {
            console.next();
            System.out.println("Not an integer; try again.");
            System.out.print(prompt);
        }
        return console.nextInt();
    }
}
