import java.util.Scanner;
/**
 * Class that reads in strings from the user and echos them back
 * Illustrates the use of main and Scanner
 * 
 * @author csc142
 * @version Winter 06
 */
public class EchoTest
{
  public static void main(String[] args) {
        
        // The way that Scanner.next() reads in strings is that it uses
        // whitespace to break up (or parse) the input into tokens 
        // (what humans would consider words)
        // whitespace is a space, a tab, or the enter key
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a word, or type 0 to quit: ");
        String s = in.next();
        
        // because s is a reference variable, we can't use == (remember, that just tests
        // addresses
        // so we use the equals() method, which tests if 2 objects have the same content
        while (! s.equals("0") ) {
            System.out.println("You entered: " + s);
            System.out.print("Enter another word, or type 0 to quit: ");
            s = in.next();
        }
        System.out.println("Good-bye");
    }
}
