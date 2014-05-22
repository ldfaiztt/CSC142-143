import java.util.*;

public class Pick2 {
    public static void main(String[] args) {
        System.out.println("This program picks numbers from");
        System.out.println("1 to 10 until a particular");
        System.out.println("number comes up.");
        System.out.println();

        Scanner console = new Scanner(System.in);
        Random r = new Random();

        System.out.print("Pick a number between 1 and 10--> ");
        int number = console.nextInt();

        int result;
        int count = 0;
        do {
            result = r.nextInt(10) + 1;
            System.out.println("next number = " + result);
            count++;
        } while (result != number);
        System.out.println("Your number came up after " + 
                           count + " times");
    }
}
