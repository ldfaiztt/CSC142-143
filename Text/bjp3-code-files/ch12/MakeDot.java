// Variation of GoNorthEast that produces a dot file for graphviz

import java.util.*;
import java.io.*;

public class MakeDot {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        System.out.print("Target x and y location? ");
        int x = console.nextInt();
        int y = console.nextInt();
        System.out.println();
        solve(x, y);
    }

    private static void explore(int stepsLeft, String path, 
                                PrintStream output, String oldDot, 
                                String indent) {
        String newDot;
        if (oldDot.isEmpty()) {
            newDot = "\"start\"";
            System.out.println("foo: " + path);
        } else {
            newDot = "\"" + path.trim() + "\"";
            output.println(indent + oldDot + " -> " + newDot);
            indent += "    ";
        }
        if (stepsLeft == 0) {
	    System.out.println("moves:" + path);
	} else {
	    explore(stepsLeft - 1, path + " N", output, newDot, indent);
	    explore(stepsLeft - 1, path + " E", output, newDot, indent);
	    explore(stepsLeft - 1, path + " NE", output, newDot, indent);
	}
    }

    public static void solve(int x, int y) throws FileNotFoundException {
        PrintStream output = new PrintStream(new File("ne.dot"));
        output.println("digraph {");
	System.out.println("solutions:");
        explore(x + y, "", output, "", "    ");
        output.println("}");
    }
}