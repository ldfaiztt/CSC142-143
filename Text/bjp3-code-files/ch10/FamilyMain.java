import java.util.*;
import java.io.*;

public class FamilyMain {
    public static void main (String[] args) throws FileNotFoundException {
        giveIntro();
        Scanner console = new Scanner(System.in);
        Scanner input = new Scanner(new File("tudor.dat"));
        FamilyDatabase family = new FamilyDatabase(input);
        family.print();
        doMatches(family, console);
    }

    public static void giveIntro() {
        System.out.println("This program reads an input file with family");
        System.out.println("information and provides information about the");
        System.out.println("maternal line, paternal line and children of");
        System.out.println("various people.");
        System.out.println();
    }

    public static void doMatches(FamilyDatabase family, Scanner console) {
        System.out.print("next person (enter to quit)? ");
        String name = console.nextLine();
        while (name.length() > 0) {
            Person next = family.find(name);
            if (next == null) {
                System.out.println("No match.");
            } else {
                showMaternal(next);
                showPaternal(next);
                showChildren(next);
            }
            System.out.println();
            System.out.print("next person (enter to quit)? ");
            name = console.nextLine();
        }
    }

    /* Shows maternal ancestors for given person */
    public static void showMaternal(Person current) {
        System.out.println("Maternal line:");
        int level = 1;
        while (current != null) {
            for (int i = 0; i < level; i++)
                System.out.print("    ");
            System.out.println(current.getName());
            current = current.getMother();
            level++;
        }
    }

    /* Shows paternal ancestors for given person */
    public static void showPaternal(Person current) {
        System.out.println("Paternal line:");
        int level = 1;
        while (current != null) {
            for (int i = 0; i < level; i++)
                System.out.print("    ");
            System.out.println(current.getName());
            current = current.getFather();
            level++;
        }
    }

    /* Shows children for given person */
    public static void showChildren(Person current) {
        ArrayList<Person> kids = current.getChildren();
        System.out.println("Children:");
        if (kids.size() == 0) {
            System.out.println("    none");
        } else {
            for (Person kid: kids) {
                System.out.println("    " + kid.getName());
            }
        }
    }
}
