import java.util.*;

public class ShuffleExample {
    public static void main(String[] args) {
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8",
                "9", "10", "Jack", "Queen", "King", "Ace"};
        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        
        ArrayList<String> cards = new ArrayList<String>();
        for (String rank : ranks) {
            for (String suit : suits) {
                cards.add(rank + " of " + suit);
            }
        }
        Collections.shuffle(cards);
        System.out.println("Top card = " + cards.get(0));
    }
}
