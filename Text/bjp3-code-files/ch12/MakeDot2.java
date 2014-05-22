// Variation of GoNorthEast that produces a dot file for graphviz

import java.util.*;
import java.io.*;

public class MakeDot2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        System.out.print("Target x and y location? ");
        int x = console.nextInt();
        int y = console.nextInt();
        System.out.println();
        solve(x, y);
    }

    private static void explore(int currX, int currY, 
                                int stepsLeft, String path, 
                                PrintStream output, String oldDot, 
                                String indent) {
        String coords = "(" + currX + ", " + currY + ")";
        String newDot;
        if (oldDot.isEmpty()) {
            newDot = "\"start\\n(0, 0)\"";
        } else {
            newDot = "\"" + path.trim() + "\\n" + coords + "\"";
            output.println(indent + oldDot + " -> " + newDot);
            indent += "    ";
        }
        if (stepsLeft == 0) {
	    System.out.println(path + ": (" + currX + ", " + currY + ")");
	} else {
	    explore(currX, currY + 1, 
                    stepsLeft - 1, path + " N", output, newDot, indent);
	    explore(currX + 1, currY,
                    stepsLeft - 1, path + " E", output, newDot, indent);
	    explore(currX + 1, currY + 1, 
                    stepsLeft - 1, path + " NE", output, newDot, indent);
	}
    }

    public static void solve(int x, int y) throws FileNotFoundException {
        PrintStream output = new PrintStream(new File("ne2.dot"));
        output.println("digraph {");
	System.out.println("solutions:");
        explore(0, 0, x + y, "", output, "", "    ");
        output.println("}");
    }
}