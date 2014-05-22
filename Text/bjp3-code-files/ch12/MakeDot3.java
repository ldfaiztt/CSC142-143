// Variation of GoNorthEast that produces a dot file for graphviz

import java.util.*;
import java.io.*;

public class MakeDot3 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        System.out.print("Target x and y location? ");
        int x = console.nextInt();
        int y = console.nextInt();
        System.out.println();
        solve(x, y);
    }

    private static void explore(int currX, int currY, int x, int y,
                                int stepsLeft, String path, 
                                PrintStream output, String oldDot, 
                                String indent) {
        String coords = "(" + currX + ", " + currY + ")";
        String newDot;
        if (oldDot.isEmpty()) {
            newDot = "\"start: (0, 0)\"";
        } else {
            newDot = "\"" + path.trim() + ": " + coords + "\"";
            output.println(indent + oldDot + " -> " + newDot);
            indent += "    ";
        }
        if (currX == x && currY == y) {
	    System.out.println(path);
            output.println(newDot + " [color=blue fontcolor=red]");
        }
        if (stepsLeft > 0) {
	    explore(currX, currY + 1, x, y,
                    stepsLeft - 1, path + " N", output, newDot, indent);
	    explore(currX + 1, currY, x, y,
                    stepsLeft - 1, path + " E", output, newDot, indent);
	    explore(currX + 1, currY + 1,  x, y,
                    stepsLeft - 1, path + " NE", output, newDot, indent);
	}
    }

    public static void solve(int x, int y) throws FileNotFoundException {
        PrintStream output = new PrintStream(new File("ne3.dot"));
        output.println("digraph {");
	System.out.println("solutions:");
        explore(0, 0, x, y, x + y, "", output, "", "    ");
        output.println("}");
    }
}