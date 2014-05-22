import java.util.*;

public class ExamineInput1 {
    public static void main(String[] args) {
        System.out.println("This program examines the ways");
        System.out.println("a token can be read.");
        System.out.println();

        Scanner console = new Scanner(System.in);

        System.out.print("token? ");
        System.out.println("  hasNextInt = " +
                           console.hasNextInt());
        System.out.println("  hasNextDouble = " +
                           console.hasNextDouble());
        System.out.println("  hasNext = " + console.hasNext());
    }
}
